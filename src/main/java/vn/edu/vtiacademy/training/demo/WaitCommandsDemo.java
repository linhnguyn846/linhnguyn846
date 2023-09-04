package vn.edu.vtiacademy.training.demo;

import org.openqa.selenium.By;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class WaitCommandsDemo {

  public static final String SITEDEMO_URL = "https://demoqa.com/";

  public static final String PNL_SECTIONS = "//div[@class='category-cards']/a";

  public static void main(String[] args) {

    WebUI webUI = new WebUI();
    webUI.openBrowser("Chrome", SITEDEMO_URL);
//    webUI.setImplicitlyWait(60);
    webUI.maximizeWindow();
    webUI.findElement(PNL_SECTIONS, 30);
    webUI.findElement(PNL_SECTIONS);

  }

}
