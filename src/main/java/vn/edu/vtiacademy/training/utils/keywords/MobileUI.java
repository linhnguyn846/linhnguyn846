package vn.edu.vtiacademy.training.utils.keywords;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import java.io.File;
import java.net.URL;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import vn.edu.vtiacademy.training.utils.driver.mobile.MobileDriverManager;
import vn.edu.vtiacademy.training.utils.driver.mobile.MobileDriverManagerFactory;
import vn.edu.vtiacademy.training.utils.driver.mobile.MobileDriverType;
import vn.edu.vtiacademy.training.utils.helper.AllureLogger;
import vn.edu.vtiacademy.training.utils.helper.LogHelper;
import vn.edu.vtiacademy.training.utils.helper.PropertyHelper;

public class MobileUI {
    private static final int defaultTimeOut = 60;
    private static Logger logger = LogHelper.getLogger();
    private static String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";
    private static String APP_PATH =
            System.getProperty("user.dir") + File.separator + "apps" + File.separator;
    public WebDriver driver;
    private MobileDriverManager mobileDriverManager;

//
public void startApplication(String appName) {
    try {
        logger.info(MessageFormat.format("Starting application: ''{0}''", appName));
        mobileDriverManager = MobileDriverManagerFactory.getManager(
            MobileDriverType.valueOf(PropertyHelper.getProperty("platformName").toUpperCase()));
        mobileDriverManager.createDriver(appName);
        logger.info(MessageFormat.format("Started application ''{0}'' successfully", appName));
    } catch (Exception e) {
        logger.error(
            MessageFormat.format("Cannot start application ''{0}''. Root cause: {1}", appName,
                e.getMessage()));
    }
}

    public void delayInSecond(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
            logger.info(MessageFormat.format("Delayed ''{0}'' seconds", seconds));
        } catch (InterruptedException e) {
            logger.error(MessageFormat.format("Cannot delay ''{0}'' second(s)", seconds));
        }
    }

    public void closeApplication() {
        try {
            logger.info("Closing the application");
            driver.quit();
            logger.info("Closed the application successfully");
        } catch (Exception e) {
            logger.error(
                    MessageFormat.format("Cannot close the application. Root cause: {0}", e.getMessage()));
        }
    }

    public By findBy(String locator) {
        int prefixLocator = locator.indexOf(":"); //lấy vị trí của ký tự : là vị trí số 2
        if (prefixLocator < 0) { // nếu không có ký tự : thì sẽ prefixLocator = -1
            prefixLocator = 0; // gán lại prefixLocator = 0
        }

        String locatorType = locator.substring(0, prefixLocator); // locatorType = id (0 - 2)
        if (locatorType.isEmpty() || locatorType.isBlank() || locatorType.length() >= 5) {
            locatorType = "xpath";
        }
        String locatorExpression;
        if (prefixLocator == 0) {
            locatorExpression = locator.substring(prefixLocator);
        } else {
            locatorExpression = locator.substring(prefixLocator + 1); // locatorExpression = abc
        }
        switch (locatorType) {
            case "class":
                return By.className(locatorExpression);
            case "xpath":
            default:
                return By.xpath(locatorExpression);
        }
    }

    public WebElement findElement(By locator, int... timeOut) {
        WebElement element = null;
        int waitTime = timeOut.length != 0 ? timeOut[0] : defaultTimeOut;
        logger.info(MessageFormat.format("Finding web element located by ''{0}''", locator));
        AllureLogger.info(MessageFormat.format("Finding web element located by ''{0}''", locator));
//    WebDriver driver = driverManager.getDriver();
        try {
            Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(waitTime))
                    .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
            element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(locator);
                }
            });
            logger.info(MessageFormat.format("Found {0} web element located by ''{1}''", 1, locator));
            AllureLogger.info(
                    MessageFormat.format("Found {0} web element located by ''{1}''", 1, locator));
        } catch (Exception e) {
            logger.error(
                    MessageFormat.format("Cannot find web element located by ''{0}''. Root cause: {1}",
                            locator, e.getMessage()));
            AllureLogger.error(
                    MessageFormat.format("Cannot find web element located by ''{0}''. Root cause: {1}",
                            locator, e.getMessage()));
        }
        return element;
    }

    public WebElement findElement(String locator, int... timeOut) {
        WebElement element = null;
        int waitTime = timeOut.length != 0 ? timeOut[0] : defaultTimeOut;
        logger.info(MessageFormat.format("Finding web element located by ''{0}''", locator));
        AllureLogger.info(MessageFormat.format("Finding web element located by ''{0}''", locator));
//    WebDriver driver = driverManager.getDriver();
        try {
            Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(waitTime))
                    .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
            element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(findBy(locator));
                }
            });
            logger.info(MessageFormat.format("Found {0} web element located by ''{1}''", 1, locator));
            AllureLogger.info(
                    MessageFormat.format("Found {0} web element located by ''{1}''", 1, locator));
        } catch (Exception e) {
            logger.error(
                    MessageFormat.format("Cannot find web element located by ''{0}''. Root cause: {1}",
                            locator, e.getMessage()));
            AllureLogger.error(
                    MessageFormat.format("Cannot find web element located by ''{0}''. Root cause: {1}",
                            locator, e.getMessage()));
        }
        return element;
    }

    public void tap(String locator) {
        WebDriver driver = mobileDriverManager.getDriver();
        try {
            logger.info(MessageFormat.format("Tap on mobile element located by ''{0}''", locator));
            WebElement we = findElement(locator);
            new TouchAction<>((PerformsTouchActions) driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(we)))
                .perform();
            logger.info(MessageFormat.format("Tapped on mobile element located by ''{0}'' successfully",
                locator));
        } catch (Exception e) {
            logger.error(
                MessageFormat.format("Cannot tap on mobile element located by ''{0}''. Root cause: {1}",
                    locator, e.getMessage()));
        }
    }

    public void setText(By locator, String value) {
        WebElement element = findElement(locator);
        if (element != null) {
            try {
                element.sendKeys(value);
                logger.info("Entered text '" + value + "' into element: " + locator.toString());
            } catch (Exception e) {
                logger.error("Cannot enter text into element: " + locator.toString() + ". Root cause: "
                        + e.getMessage());
            }
        }
    }

    public void setText(String locator, String value) {
        WebElement element = findElement(findBy(locator));
        if (element != null) {
            try {
                element.sendKeys(value);
                logger.info("Entered text '" + value + "' into element: " + locator);
            } catch (Exception e) {
                logger.error("Cannot enter text into element: " + locator + ". Root cause: "
                        + e.getMessage());
            }
        }
    }
}
