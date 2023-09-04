package vn.edu.vtiacademy.training.tests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import vn.edu.vtiacademy.training.utils.helper.LogHelper;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

@CucumberOptions(
        features = {"src/main/resources/feature/login.feature"},
        glue ={"vn.edu.vtiacademy.training.steps", "vn.edu.vtiacademy.training.steps.Hooks"},
        plugin={"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    protected static Logger logger = LogHelper.getLogger();

    protected static WebUI webUI;
    public TestNGRunner() {
        webUI = new WebUI();
    }
}
