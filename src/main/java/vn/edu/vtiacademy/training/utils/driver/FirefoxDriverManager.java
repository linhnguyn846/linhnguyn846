package vn.edu.vtiacademy.training.utils.driver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {



  @Override
  protected void createDriver() {
//    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
  }
  }





