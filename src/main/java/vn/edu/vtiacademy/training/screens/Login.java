package vn.edu.vtiacademy.training.screens;
import io.qameta.allure.Step;
import vn.edu.vtiacademy.training.object_repo.mobile.android.Android_LoginRepo;
import vn.edu.vtiacademy.training.object_repo.mobile.ios.IOS_LoginRepo;
import vn.edu.vtiacademy.training.utils.helper.PropertyHelper;
import vn.edu.vtiacademy.training.utils.keywords.MobileUI;
public class Login extends BaseScreen{
    public Login(MobileUI mobileUI) {
        super(mobileUI);
        logger.info("Login");
    }

    @Step("Input user email: {0}")
    public void inputUserEmail(String email) {
        if(PropertyHelper.getProperty("platformName").equals("Android")) {
            mobileUI.setText(Android_LoginRepo.TXT_EMAIL, email);
        } else {
            mobileUI.setText(IOS_LoginRepo.TXT_EMAIL, email);
        }
    }

    @Step("Input user password: {0}")
    public void inputUserPassword(String password) {
        if(PropertyHelper.getProperty("platformName").equals("Android")) {
            mobileUI.setText(Android_LoginRepo.TXT_PASSWORD, password);
        } else {
            mobileUI.setText(IOS_LoginRepo.TXT_PASSWORD, password);
        }
    }

    @Step("Click Login Button")
    public void clickLoginButton() {
        if(PropertyHelper.getProperty("platformName").equals("Android")) {
            mobileUI.tap(Android_LoginRepo.BTN_LOGIN);
        } else {
            mobileUI.tap(IOS_LoginRepo.BTN_LOGIN);
        }
    }
}
