package vn.edu.vtiacademy.training.screens;

import org.slf4j.Logger;
import vn.edu.vtiacademy.training.utils.helper.LogHelper;
import vn.edu.vtiacademy.training.utils.keywords.MobileUI;

public class BaseScreen {
    protected MobileUI mobileUI;
    protected Logger logger = LogHelper.getLogger();

    public BaseScreen(MobileUI mobileUI) {
        logger.info("BaseScreen");
        this.mobileUI = mobileUI;
    }
}
