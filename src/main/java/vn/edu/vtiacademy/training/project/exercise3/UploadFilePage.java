package vn.edu.vtiacademy.training.project.exercise3;
import static org.testng.Assert.assertTrue;
import vn.edu.vtiacademy.training.utils.helper.FileHelper;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import vn.edu.vtiacademy.training.project.exercise3.UploadFileRepo;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;
public class UploadFilePage extends BasePage {
  public UploadFilePage (WebUI webUI) {
    super(webUI);
  }

  @Step("Upload file sucessfull by sendkey method")
  public boolean verifyUploadFileSucessfullyBySendkeyMethod(String fileName){
    String filepath = FileHelper.getDataJSONFilePathOneSeparator(fileName);
    webUI.clickElement(UploadFileRepo.UPLOAD_BTN);
    webUI.uploadFile(UploadFileRepo.UPLOAD_BTN,filepath);
    webUI.takeScreenShotAndHighLightElement(UploadFileRepo.UPLOAD_BTN);
    String expectedText1 = "C:" + "\\" + "fakepath" + "\\" + fileName;
    return webUI.verifyElementAttributeValue(UploadFileRepo.UPLOAD_BTN, "value",
            expectedText1);


  }
  public boolean verifyUploadedFileUsingRobotClass(String fileName){
    String filepath = FileHelper.getDataJSONFilePathOneSeparator(fileName);
    webUI.clickUsingActions(UploadFileRepo.UPLOAD_BTN);
    webUI.uploadFileUsingRobotClass(filepath);
    webUI.delayInSecond(5);
    webUI.takeScreenShotAndHighLightElement(UploadFileRepo.UPLOAD_BTN);
    String expectedText2 = "C:" + "\\" + "fakepath" + "\\" + fileName;
    return webUI.verifyElementAttributeValue(UploadFileRepo.UPLOAD_BTN, "value",
            expectedText2);


  }



}
