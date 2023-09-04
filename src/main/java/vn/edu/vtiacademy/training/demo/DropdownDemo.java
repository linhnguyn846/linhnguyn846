package vn.edu.vtiacademy.training.demo;

import java.util.List;
import org.openqa.selenium.WebElement;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class DropdownDemo {

  private static final String SITE_DEMO_URL = "https://demoqa.com/select-menu";

  private static final String LST_OLD_STYLE_SELECT_MENU = "//select[@id='oldSelectMenu']";

  private static final String TXT_SELECT_VALUE = "//div[@id='withOptGroup']";

  private static final String DDL_VALUE_OPTIONS = "//div[starts-with(@id,'react-select-') and contains(@id,'option')]";

  private static final WebUI webUI = new WebUI();
  public static void main(String[] args) {
    webUI.openBrowser("Chrome", SITE_DEMO_URL);
    webUI.maximizeWindow();
//    webUI.selectOptionByIndex(LST_OLD_STYLE_SELECT_MENU, 3);
//    webUI.delayInSecond(5);
//    webUI.selectOptionByLabel(LST_OLD_STYLE_SELECT_MENU, "White");
//    webUI.delayInSecond(5);
//    webUI.selectOptionByValue(LST_OLD_STYLE_SELECT_MENU, "5");
//    webUI.delayInSecond(5);
//    webUI.selectOptionByIndex(LST_OLD_STYLE_SELECT_MENU, 1);
//    webUI.delayInSecond(5);
    selectValueOption("Group 1, option 2");
    webUI.delayInSecond(5);
    selectValueOption("Group 2, option 2");
    webUI.delayInSecond(5);
    webUI.closeBrowser();
  }

  public static void selectValueOption(String option) {
    webUI.clickElement(TXT_SELECT_VALUE);
    webUI.delayInSecond(5);
    List<WebElement> ddlValueOptions = webUI.findElements(DDL_VALUE_OPTIONS);
    for (WebElement ddlValueOption: ddlValueOptions) {
      String actualText = webUI.getElementText(ddlValueOption).trim();
      if(actualText.equals(option)) {
        webUI.clickElement(ddlValueOption);
        break;
      }
    }
  }
}
