package vn.edu.vtiacademy.training.steps;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import vn.edu.vtiacademy.training.tests.TestNGRunner;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;
public class Hooks extends TestNGRunner {
    @BeforeAll
    public static void beforeAll() {
        logger.info("Before All");
        webUI.openBrowser("Chrome");
    }


    @AfterAll
    public static void afterAll() {
        webUI.closeBrowser();
        logger.info("After All");
    }

}
