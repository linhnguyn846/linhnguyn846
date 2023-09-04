package vn.edu.vtiacademy.training.project.exercise1;
import static org.testng.Assert.assertTrue;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import vn.edu.vtiacademy.training.project.exercise1.TooltipRepo;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;


import java.util.List;
public class TooltipPage extends BasePage {
    public TooltipPage (WebUI webUI) {
        super(webUI);
    }
    @Step("hover button")
    public void hoverButton(){
        webUI.mouseOver(TooltipRepo.HOVER_BTN);
    }
    @Step("Should  present hover button  messsage in HTML DOM")
    public boolean shouldPresentHoverButtonInHTMLDom() {
        webUI.takeScreenShotAndHighLightElement(TooltipRepo.HOVER_BTN);
        return webUI.verifyElementPresent(TooltipRepo.HOVER_BTN);
    }
    @Step("Get Text ToolTip")
    public void getTextToolTip(){
        webUI.getTextToolTip(TooltipRepo.TOOLTIP_BTN);
        webUI.verifyElementText(TooltipRepo.TOOLTIP_BTN,"You hovered over the Button");
        webUI.takeScreenShotAndHighLightElement(TooltipRepo.TOOLTIP_BTN);
    }



}
