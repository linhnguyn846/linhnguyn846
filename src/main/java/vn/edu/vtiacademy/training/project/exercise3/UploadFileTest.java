package vn.edu.vtiacademy.training.project.exercise3;
import static org.testng.Assert.assertTrue;

import io.qameta.allure.Description;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vn.edu.vtiacademy.training.project.exercise1.TooltipPage;
import vn.edu.vtiacademy.training.project.exercise1.TooltipTest;
import vn.edu.vtiacademy.training.project.exercise3.UploadFilePage;
import vn.edu.vtiacademy.training.project.exercise3.UploadFileRepo;

public class UploadFileTest extends BaseTest {

  private UploadFilePage objUploadFile;

  public UploadFileTest() {
    super();
    objUploadFile = new UploadFilePage(this.webUI);
    setDataFile(TooltipTest.class.getSimpleName());
  }

  @Test(description = "TC001: Verify uploaded file using SendKeys method")
  @Description("Verify uploaded file using SendKeys method")
  public void TC001_verify_uploaded_file_using_sendkeys_method(Method method){
    logger.info("Test case: " + method.getName());
    assertTrue(objUploadFile.verifyUploadFileSucessfullyBySendkeyMethod("example1.jpg"), "Verify successfully");
  }


  @Test(description = "TC002: Verify uploaded file using Robot class")
  @Description("Verify uploaded file using Robot class")
  public void TC002_verify_uploaded_file_using_Robot_class(Method method){
    logger.info("Test case: " + method.getName());
    assertTrue(objUploadFile.verifyUploadedFileUsingRobotClass("example1.jpg"), "Verify successfully");
  }
}
