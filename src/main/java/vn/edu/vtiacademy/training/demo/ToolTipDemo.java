package vn.edu.vtiacademy.training.demo;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;
public class ToolTipDemo {
    private static final String SITEDEMO_URL ="https://demoqa.com/tool-tips";
    private static final String HOVER_BTN ="//button[@id='toolTipButton']";
    private static final String TOOLTIP_BTN= "//div[@class='tooltip-inner']";
    private static final WebUI webUI=new WebUI();

    public static void main(String[] args) throws InterruptedException{
        webUI.openBrowser("Chrome",SITEDEMO_URL);
        webUI.maximizeWindow();
        webUI.delayInSecond(5);
        webUI.mouseOver(HOVER_BTN);
        webUI.highlightElement(HOVER_BTN);
        webUI.delayInSecond(5);
        webUI.getTextToolTip(TOOLTIP_BTN);
        webUI.delayInSecond(5);
        webUI.closeBrowser();


    }
}
