package vn.edu.vtiacademy.training.project.exercise1;
import static org.testng.Assert.assertTrue;

import io.qameta.allure.Description;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vn.edu.vtiacademy.training.project.exercise1.TooltipPage;



public class TooltipTest extends BaseTest {
    private TooltipPage objTooltip;


    public TooltipTest() {
        super();
        objTooltip = new TooltipPage(this.webUI);
        setDataFile(TooltipTest.class.getSimpleName());
    }
    @Test(description = "TC001: Get text ToolTip Successfully", groups = {
            "smoketest", "functiontest"})
    public void TC001_get_Text_ToolTip_Sucessfully(Method method) throws InterruptedException {
        logger.info("Test case: " + method.getName());
        objTooltip.hoverButton();
//        webUI.delayInSecond(5);
        objTooltip.getTextToolTip();

    }
}
