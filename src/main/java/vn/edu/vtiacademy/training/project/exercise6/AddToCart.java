package vn.edu.vtiacademy.training.project.exercise6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import vn.edu.vtiacademy.training.project.exercise4.EditAccountRepo;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

import java.util.List;

public class AddToCart extends BasePage {
    public AddToCart(WebUI webUI){super(webUI);}

    @Step("Change language to English Successfully")
    public void changeToLanguage(){
        webUI.clickJS(AddToCartRepo.LANGUAGE_SPAN);
        webUI.takeScreenShotAndHighLightElement(AddToCartRepo.LANGUAGE_SPAN);
    }
    @Step("input search")
    public void inputSearch(String keyword){
        webUI.sendKeys(AddToCartRepo.SEARCH_TXT,keyword);
        webUI.takeScreenShotAndHighLightElement(AddToCartRepo.SEARCH_TXT);
    }
    @Step("search product keyword successfully")
    public void searchKeyword(String keyword) throws InterruptedException {
        inputSearch(keyword);
        Thread.sleep(3000);
        webUI.takeScreenShotAndHighLightElement(AddToCartRepo.SEARCH_RESULT);


    }
    @Step("Filter value sucessfully")
    public void filerScreenSizeGroupValue(String value){
        List<WebElement> ddlValues = webUI.findElements(AddToCartRepo.FILTER_VALUE);
        for (WebElement ddlValue: ddlValues) {
            String actualValue = webUI.getElementText(ddlValue).trim();
            if(actualValue.contentEquals(value)) {
                webUI.clickElement(ddlValue);
                break;
            }
        }
    }
    @Step public boolean shouldShowResultItemFoundedMessageOnUI() {

        webUI.takeScreenShotAndHighLightElement(AddToCartRepo.SEARCH_RESULT);

        return webUI.verifyElementNotVisible(AddToCartRepo.SEARCH_RESULT);
    }

    @Step("Add to cart successfully")
    public  void addToCart(String productName){
        List<WebElement> lblProducts = webUI.findElements(AddToCartRepo.PRODUCT_NAME);
        List<WebElement> likProduct = webUI.findElements(AddToCartRepo.PRODUCT_LNK);
        for(int i = 0; i < lblProducts.size(); i++) {
            String actualProduct = webUI.getElementText(lblProducts.get(i)).trim();
            if(actualProduct.equals(productName)) {
                webUI.clickUsingActions(likProduct.get(i));
                break;
            }
        }
    webUI.clickUsingActions(AddToCartRepo.ADD_BTN);
    }



    @Step("validate results of product name in the cart that match with the product name that were added")
    public boolean shouldResulOfProductNameMatchItemWereAdded(String productName,String item){
        List<WebElement> lblProductName = webUI.findElements(AddToCartRepo.PRODUCTNAME_LBL);
        List<WebElement> quantityProduct = webUI.findElements(AddToCartRepo.PRODDUCT_QUANTITY);
        for(int i = 0; i < lblProductName.size(); i++) {
            String actualProductName = webUI.getElementText(lblProductName.get(i));
            if(actualProductName.equals(productName)) {
                webUI.verifyElementAttributeValue(AddToCartRepo.PRODUCTNAME_LBL,"data-product-name",productName);
                break;
            }
        }
        return webUI.verifyElementAttributeValue(AddToCartRepo.PRODDUCT_QUANTITY,"value",item);
    }
//    @Step("validate results of item quantity in the cart that match with the item quantity that were added")
//    public boolean shouldResulOfItemQuantityMatchItemQuantiTyWereAdded(String item){
//        webUI.clickElement(AddToCartRepo.CART_BTN);
//        webUI.takeScreenShotAndHighLightElement(AddToCartRepo.PRODDUCT_QUANTITY);
//        return webUI.verifyElementAttributeValue(AddToCartRepo.PRODDUCT_QUANTITY,"value",item);
//    }






}
