package vn.edu.vtiacademy.training.demo;

import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class ScrollDemo {
  public static final String SITEDEMO_URL = "https://vnexpress.net/";
  private static final String RESTATE_TITLE ="//div[@id='batdongsan']";
  private static final String RESTATE_LINK ="//a[@class='inner-title'][contains(text(),'Bất động sản')]";
  private static final WebUI webUI =new WebUI();
  public static void main(String[] args) throws InterruptedException{
    webUI.openBrowser("Firefox",SITEDEMO_URL);
    webUI.maximizeWindow();
    webUI.delayInSecond(5);
    //webUI.scrollDown();
    webUI.delayInSecond(5);
    //webUI.findElement(SPORT_TITLE,60);
   webUI.scrollToElement(RESTATE_TITLE,60);
    webUI.delayInSecond(5);
    webUI.clickElement(RESTATE_LINK);
    webUI.delayInSecond(5);
    webUI.closeBrowser();
  }


}
