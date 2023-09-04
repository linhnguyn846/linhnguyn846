package vn.edu.vtiacademy.training.demo;
import vn.edu.vtiacademy.training.utils.keywords.MobileUI;
public class MobileCommands {
    private static String TAB_LOGIN = "//android.widget.Button[@content-desc=\"Login\"]";

    private static String TXT_EMAIL = "//android.widget.EditText[@content-desc=\"input-email\"]";

    private static String TXT_PASSWORD = "//android.widget.EditText[@content-desc=\"input-password\"]";

    private static String BTN_LOGIN = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]";

    public static void main(String[] args) {
        MobileUI mobileUI = new MobileUI();
        mobileUI.startApplication("Android-NativeDemoApp-0.4.0.apk");
        mobileUI.delayInSecond(5);
        mobileUI.tap(TAB_LOGIN);
        mobileUI.delayInSecond(5);
        mobileUI.setText(TXT_EMAIL, "test@webdriver.io");
        mobileUI.delayInSecond(5);
        mobileUI.setText(TXT_PASSWORD, "Test1234!");
        mobileUI.delayInSecond(5);
        mobileUI.tap(BTN_LOGIN);
        mobileUI.delayInSecond(20);
        mobileUI.closeApplication();
    }

}
