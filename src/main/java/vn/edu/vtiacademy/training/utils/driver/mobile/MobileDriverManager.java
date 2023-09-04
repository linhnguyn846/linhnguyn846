package vn.edu.vtiacademy.training.utils.driver.mobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import vn.edu.vtiacademy.training.utils.helper.LogHelper;

import java.io.File;
public abstract class MobileDriverManager {
  protected AppiumDriver driver;
  protected String APPIUM_SERVER_URL = "http://127.0.0.1:4723/";

  protected Logger logger = LogHelper.getLogger();
  protected static String APP_PATH =
      System.getProperty("user.dir") + File.separator + "apps" + File.separator;
  protected AppiumDriverLocalService service;

  private static String NODE_PATH = "C:\\Program Files\\nodejs\\node.exe";
  private static String APPIUM_PATH = "C:\\Users\\Windows 10\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

  public abstract void createDriver(String appName);

  public void quitDriver() {
    if (null != driver) {
      driver.quit();
      driver = null;
      service.stop();
    }
  }

  public WebDriver getDriver() {
    return driver;
  }

  public void startAppiumServer() {
//        service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).build();
    service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingAnyFreePort().usingDriverExecutable(new File(NODE_PATH)).
        withAppiumJS(new File(APPIUM_PATH)));
    service.start();
  }

}


