package vn.edu.vtiacademy.training.demo;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

import javax.naming.ldap.PagedResultsControl;

public class EcommerceDemo {
    private static final String SITEDEMO_URL="https://www.powerbuy.co.th/en/cart";
    private static final String LANGUAGE_SPAN ="//span[@id='lnk-setLanguageDesktop-en']";
    private static final String SEARCH_TXT ="//div[@class='MainHeader__SearchContainer-ezhahy iqrizX']//input[@id='txt-searchBox-input']";
    public static final String FILTER_LBL="//div[@title='Screen Size Group (inches)']//div[@class='CardCollaspe__CardAnimation-sc-1jxh92o-2 bAxvMY']";
    public static final String FILTER_VALUE="//body/div[@id='app']/div[@id='layout']/div/div/div/div[@class='AlgoliaSearchResult__LoadingCover-ibKHie dMKOUm']/div[@class='Media__HideMobile-sc-1gp5uia-0 kKkhle']/div[@class='AlgoliaSearchResultDesktop__SearchResultContainer-bUeriv tLMUi']/div[@class='AlgoliaSearchResultDesktop__SearchResultWrapper-fbpVhw huJsvN']/div[@class='AlgoliaSearchResultDesktop__FiltersWrapper-huGKON eApjWs']/div[@class='Card__BgColor-sc-13y6ap0-0 gzoOtT']/div[@class='CardBody__Body-sc-1xt43yy-0 gwyEQW']/div[@title='Screen Size Group (inches)']/div[@class='CardCollaspe__CardAnimation-sc-1jxh92o-2 bAxvMY']/div[@class='CardCollaspe__CardBody-sc-1jxh92o-3 dGVUKK']/div[@class='styled__TopLine-jkdHEQ cCGivF']/div[1]/div[1]/div[1]";
    private static final String PRODUCT_LNK="//div[@class='Row__Wrapper-v6uxgu-0 kSLyDU']//a[@id='lnk-viewProduct-281502']";
    private static final String ADD_BTN="//div[@class='Col__Column-sc-1619uro-0 bWadEp']//div[@class='Row__Wrapper-v6uxgu-0 kSLyDU']//div[@class='Col__Column-sc-1619uro-0 cPDxnm']//div//button[@id='btn-addCart-281502']";
    private static final String PRODUCTNAME_LBL="//div[@class='Row__Wrapper-v6uxgu-0 kSLyDU CartItems__RowItem-gowMeA jyJghz']";
    private static final String PRODDUCT_QUANTITY="//input[@id='txt-productQty-281502']";
    private static final String CART_BTN="//div[@class='MainHeader__MiniCartContainer-cOzool KbPez']//a[@id='btn-openMiniCart']";
    private static final WebUI webUI=new WebUI();

    public static void main(String[] args) {
        webUI.openBrowser("Edge",SITEDEMO_URL);
        webUI.maximizeWindow();
        webUI.clickElement(LANGUAGE_SPAN);
        webUI.sendKeys(SEARCH_TXT,"TV");
        webUI.delayInSecond(20);
        webUI.scrollToElement(FILTER_LBL);
        webUI.clickJS(FILTER_VALUE);
        webUI.clickElement(PRODUCT_LNK);
        webUI.clickElement(ADD_BTN);
        webUI.clickElement(CART_BTN);
        webUI.closeBrowser();
    }


}
