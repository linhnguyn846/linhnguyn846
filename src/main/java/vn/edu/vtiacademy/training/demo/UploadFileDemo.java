package vn.edu.vtiacademy.training.demo;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;
public class UploadFileDemo {
  private static final String SITEDEMO_URL ="https://demoqa.com/upload-download";
  private static final String UPLOAD_BTN ="//input[@id='uploadFile']";

  private static final WebUI webUI=new WebUI();

  public static void main(String[] args) throws InterruptedException{
    webUI.openBrowser("Firefox",SITEDEMO_URL);
    webUI.maximizeWindow();
    webUI.delayInSecond(5);
    webUI.clickElement(UPLOAD_BTN);
    webUI.delayInSecond(5);
    webUI.uploadFile(UPLOAD_BTN,"D:\\2023\\AutomationTest\\VTI_AT-20230524_Selenium\\AutomationFramework\\src\\main\\resources\\file\\example1.jpg");
    webUI.delayInSecond(5);
    webUI.closeBrowser();


  }
}
