package vn.edu.vtiacademy.training.utils.driver.mobile;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import vn.edu.vtiacademy.training.utils.helper.PropertyHelper;

import java.net.MalformedURLException;
import java.net.URL;
public class IOSDriverManager extends MobileDriverManager {
  @Override
  public void createDriver(String appName) {
    DesiredCapabilities dc = new DesiredCapabilities();
    dc.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertyHelper.getProperty("platformName"));
    dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertyHelper.getProperty("platformVersion"));
    dc.setCapability(MobileCapabilityType.APP, APP_PATH + appName);
    dc.setCapability(MobileCapabilityType.UDID, PropertyHelper.getProperty("udid"));
    dc.setCapability(MobileCapabilityType.DEVICE_NAME, PropertyHelper.getProperty("deviceName"));
    dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
    try {
      driver = new IOSDriver(new URL(APPIUM_SERVER_URL), dc);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }
}
