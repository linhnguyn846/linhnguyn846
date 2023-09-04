package vn.edu.vtiacademy.training.screens;
import io.qameta.allure.Step;
import vn.edu.vtiacademy.training.object_repo.mobile.android.Android_HomeRepo;
import vn.edu.vtiacademy.training.object_repo.mobile.ios.IOS_HomeRepo;
import vn.edu.vtiacademy.training.utils.helper.PropertyHelper;
import vn.edu.vtiacademy.training.utils.keywords.MobileUI;
public class Home extends BaseScreen {
    public Home(MobileUI mobileUI) {
        super(mobileUI);
        logger.info("Home");
    }

    @Step("Tap on Login tab")
    public Login tapOnLoginTab() {
        if(PropertyHelper.getProperty("platformName").equals("Android")) {
            mobileUI.tap(Android_HomeRepo.TAB_LOGIN);
        } else {
            mobileUI.tap(IOS_HomeRepo.TAB_LOGIN);
        }
        return new Login(mobileUI);
    }

}
