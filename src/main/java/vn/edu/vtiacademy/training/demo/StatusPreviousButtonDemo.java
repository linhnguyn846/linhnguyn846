package vn.edu.vtiacademy.training.demo;
import org.openqa.selenium.WebElement;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class StatusPreviousButtonDemo {
    public static final String SITEDEMO_URL = "https://www.ebay.com/sch/i.html?_from=R40&_trksid=p4432023.m570.l1313&_nkw=iphone%2012&_sacat=0&fbclid=IwAR1FUUGSpix-uKTk9QmTFuUYj8nl4piQbnhSt7cF4nPAZ68LpA25kNxsFJM";
    private static final String PREVIOUS_BTN = "//button[@aria-label='Go to previous search page']";

    private static final WebUI webUI = new WebUI();

    public static void main(String[] args) throws InterruptedException {
        webUI.openBrowser("Chrome", SITEDEMO_URL);
        webUI.maximizeWindow();
        webUI.delayInSecond(5);
        webUI.delayInSecond(5);
        webUI.scrollToElement(PREVIOUS_BTN, 60);
        webUI.delayInSecond(5);
        webUI.getElementAttribute(PREVIOUS_BTN,"aria-disabled");
        showIsDisable(PREVIOUS_BTN);

        webUI.delayInSecond(5);
        webUI.closeBrowser();
    }
    public static boolean showIsDisable(String locator){
        WebElement element= webUI.findElement(PREVIOUS_BTN,60);
        String value =element.getAttribute("aria-disabled");
        if(value !=null && !value.isEmpty()){
            return webUI.verifyElementNotClickable(PREVIOUS_BTN);
        }
        return webUI.verifyElementClickable(PREVIOUS_BTN);
    }



}


