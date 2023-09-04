package vn.edu.vtiacademy.training.project.exercise6;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vn.edu.vtiacademy.training.project.exercise4.EditAccount;
import vn.edu.vtiacademy.training.project.exercise4.EditAccountTest;
import vn.edu.vtiacademy.training.project.exercise6.BaseTest;

import java.lang.reflect.Method;
import java.text.MessageFormat;

import static org.testng.Assert.assertTrue;
public class AddToCartTest extends BaseTest {
    private AddToCart objAddToCart;
    public AddToCartTest(){
        super();
        objAddToCart = new AddToCart(this.webUI);
        setDataFile(AddToCartTest.class.getSimpleName());
    }
    @Test(description = "TC001: Add to cart Successfully", groups = {
            "smoketest", "functiontest"})
    public void TC001_add_to_cart_successfully(Method method) throws InterruptedException {
        logger.info("Test case: " + method.getName());
        SoftAssert softAssertion = new SoftAssert();
        objAddToCart.changeToLanguage();
        objAddToCart.inputSearch("TV");
        softAssertion.assertTrue(objAddToCart.shouldShowResultItemFoundedMessageOnUI());
        objAddToCart.filerScreenSizeGroupValue(findTestData("AC001.filter_value[1]"));
        objAddToCart.addToCart(findTestData("AC001.product_name[1]"));
        webUI.back();
        objAddToCart.filerScreenSizeGroupValue(findTestData("AC001.filter_value[2]"));
        objAddToCart.addToCart(findTestData("AC001.product_name[2]"));
        softAssertion.assertTrue(objAddToCart.shouldResulOfProductNameMatchItemWereAdded(findTestData("AC001.product_name[1]"),"1"));

        softAssertion.assertTrue(objAddToCart.shouldResulOfProductNameMatchItemWereAdded(findTestData("AC001.product_name[2]"),"1"));






    }
}
