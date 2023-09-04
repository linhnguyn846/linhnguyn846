package vn.edu.vtiacademy.training.project.exercise4;
import org.slf4j.Logger;
import vn.edu.vtiacademy.training.component.AdvertisementPopup;
import vn.edu.vtiacademy.training.component.LeftMenu;
import vn.edu.vtiacademy.training.utils.helper.LogHelper;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;
public class BasePage {
    protected Logger logger = LogHelper.getLogger();
    protected WebUI webUI;

    //has a: Page has a advertisement popup, left menu => Manager or New Customer has components: advertisement popup, left menu
    public AdvertisementPopup objAdvertisementPopup;
    public LeftMenu objLeftMenu;

    public BasePage(WebUI webUI) {
        this.webUI = webUI;
        objAdvertisementPopup = new AdvertisementPopup(this.webUI);
        objLeftMenu = new LeftMenu(this.webUI);
    }



}
