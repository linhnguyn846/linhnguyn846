package vn.edu.vtiacademy.training.tests.mobile;
import org.testng.annotations.Test;
import vn.edu.vtiacademy.training.screens.Home;
import vn.edu.vtiacademy.training.screens.Login;
public class LoginTest extends BaseMobileTest {
    private Home objHome;
    private Login objLogin;

    @Test(description = "Login successfully")
    public void LG001_Login_successfully() {
        objHome = new Home(mobileUI);
        objLogin = objHome.tapOnLoginTab();
        objLogin.inputUserEmail("test@webdriver.io");
        objLogin.inputUserPassword("Test1234!");
        objLogin.clickLoginButton();
    }
}

