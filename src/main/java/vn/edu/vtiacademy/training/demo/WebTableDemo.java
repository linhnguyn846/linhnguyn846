package vn.edu.vtiacademy.training.demo;

import java.util.List;
import org.openqa.selenium.WebElement;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class WebTableDemo {

  private static final String WEB_TABLE_URL = "https://demoqa.com/webtables";

  private static final String BTN_ADVERTISING_CLOSE = "//a[@id='close-fixedban']";
  private static final String USER_TABLE_LBL_EMAILS = "//div[@role='row']/div[@role='gridcell'][4]";

  private static final String USER_TABLE_BTN_EDITS = "//div[@class='rt-tr -even']//div[@class='action-buttons']";

  private static final String REGISTRATION_FORM_TXT_FIRST_NAME = "//input[@id='firstName']";
  private static final String BTN_EDITS ="//span[@id='edit-record-1']";

  private static final WebUI webUI = new WebUI();
  public static void main(String[] args) {
    webUI.openBrowser("Chrome", WEB_TABLE_URL);
    webUI.maximizeWindow();
    webUI.delayInSecond(5);
    closeAdvertisingPopup();
    webUI.delayInSecond(5);
    //webUI.clickOffset(USER_TABLE_BTN_EDITS,-15,0);
    webUI.doubleClick(BTN_EDITS);
    webUI.delayInSecond(5);
    //editEmail("cierra@example.com", "Halo");
    //webUI.delayInSecond(5);
    webUI.closeBrowser();
  }

  public static void closeAdvertisingPopup() {
    if(webUI.waitForElementVisible(BTN_ADVERTISING_CLOSE, 120)) {
      webUI.clickUsingActions(BTN_ADVERTISING_CLOSE);
    }
  }

  public static void editEmail(String email, String newName) {
    List<WebElement> lblEmails = webUI.findElements(USER_TABLE_LBL_EMAILS);
    List<WebElement> btnEdits = webUI.findElements(USER_TABLE_BTN_EDITS);
    for(int i = 0; i < lblEmails.size(); i++) {
      String actualEmail = webUI.getElementText(lblEmails.get(i)).trim();
      if(actualEmail.equals(email)) {
        webUI.clickUsingActions(btnEdits.get(i));
        break;
      }
    }
    inputFirstName(newName);
  }


  public static void inputFirstName(String name) {
    webUI.clearText(REGISTRATION_FORM_TXT_FIRST_NAME);
    webUI.setText(REGISTRATION_FORM_TXT_FIRST_NAME, name);
  }


}
