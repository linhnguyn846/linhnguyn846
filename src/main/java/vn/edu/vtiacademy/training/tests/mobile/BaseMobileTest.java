package vn.edu.vtiacademy.training.tests.mobile;
import org.slf4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import vn.edu.vtiacademy.training.tests.BaseTest;
import vn.edu.vtiacademy.training.utils.helper.LogHelper;
import vn.edu.vtiacademy.training.utils.helper.PropertyHelper;
import vn.edu.vtiacademy.training.utils.keywords.MobileUI;
public class BaseMobileTest {
    private static final String ANDROID_APP_NAME = "Android-NativeDemoApp-0.4.0.apk";

    private static final String IOS_APP_NAME = "wdioNativeDemoApp.app";

    protected MobileUI mobileUI;

    protected Logger logger = LogHelper.getLogger();

    public BaseMobileTest() {
        logger.info("BaseMobileTest");
        mobileUI = new MobileUI();
    }

    @Parameters({"device"})
    @BeforeTest
    public void beforeTest(String device) {
        logger.info("beforeTest");
        new PropertyHelper(device);
        if (PropertyHelper.getProperty("platformName").equals("Android")) {
            mobileUI.startApplication(ANDROID_APP_NAME);
        } else {
            mobileUI.startApplication(IOS_APP_NAME);
        }
    }

    @AfterTest
    public void afterTest() {
        mobileUI.closeApplication();
        logger.info("afterTest");
    }
}
