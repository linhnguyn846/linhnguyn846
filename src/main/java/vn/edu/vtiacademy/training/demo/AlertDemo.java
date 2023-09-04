package vn.edu.vtiacademy.training.demo;

import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class AlertDemo {

  private static final String ALERT_URL = "https://demoqa.com/alerts";

  private static final String BTN_SIMPLE_CLICK_ME = "//button[@id='alertButton']";

  private static final String BTN_PROMPT_CLICK_ME = "//button[@id='promtButton']";

  private static final String BTN_CONFIRM_CLICK_ME = "//button[@id='confirmButton']";

  public static void main(String[] args) {
    WebUI webUI = new WebUI();
    webUI.openBrowser("Chrome", ALERT_URL);
    webUI.maximizeWindow();
    webUI.delayInSecond(5);
    webUI.clickElement(BTN_SIMPLE_CLICK_ME);
    webUI.delayInSecond(5);
    webUI.acceptAlert();
    webUI.delayInSecond(5);
    webUI.clickElement(BTN_PROMPT_CLICK_ME);
    webUI.setAlertText("Abc");
    webUI.delayInSecond(5);
    webUI.acceptAlert();
    webUI.delayInSecond(5);
    webUI.clickElement(BTN_CONFIRM_CLICK_ME);
    webUI.delayInSecond(5);
    webUI.acceptAlert();
    webUI.delayInSecond(5);
    webUI.closeBrowser();
  }

}
