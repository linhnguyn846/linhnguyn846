package vn.edu.vtiacademy.training.steps;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import vn.edu.vtiacademy.training.object_repo.LoginRepo;
import vn.edu.vtiacademy.training.pages.Login;
import vn.edu.vtiacademy.training.tests.TestNGRunner;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class LoginSteps extends TestNGRunner {
    private static final String DEMO_GURU99_URL = "https://demo.guru99.com/v4/";

    private final Login objLogin;

    public LoginSteps() {
//    super();
        logger.info("Login Steps");
        objLogin = new Login(webUI);
    }

    // glue code
    @Given("^[a-zA-Z].* navigate to Login page")
    public static void navigateToLoginPage() {
        webUI.navigateToUrl(DEMO_GURU99_URL);
        logger.info("Navigating to ''{0}''");
    }

    @When("^[a-zA-Z].* input \"([^\"]*)\" into user id text box$")
    public void inputIntoUserIdTextBox(String userId) {
        userId = userId.equals("{EMPTY}") ? "" : userId;
        userId = userId.equals("{SPACE}") ? " " : userId;
        objLogin.inputUserId(userId);
    }

    @When("^[a-zA-Z].* enter below info into user id text box")
    public void inputIntoUserIdTextBox(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        String text = data.get(0).get(0);
//    if(text.equals("{EMPTY}")) {
//      text = "";
//    }
        text = text.equals("{EMPTY}") ? "" : text;
        objLogin.inputUserId(text);
    }

    @When("^[a-zA-Z].* input below info into user id text box")
    public void enterIntoUserIdTextBox(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(); // [{"userId": "{EMPTY}"}]
        String text = data.get(0).get("userId");
        if (text.equals("{EMPTY}")) {
            text = "";
        }
        objLogin.inputUserId(text);
    }

    @When("^[a-zA-Z].* enter <userId> into user id text box")
    public void setIntoUserIdTextBox(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(); // [{"userId": "{EMPTY}"}]
        String text = data.get(0).get("userId");
        if (text.equals("{EMPTY}")) {
            text = "";
        }
        objLogin.inputUserId(text);
    }

    @Then("^[a-zA-Z].* should be to show \"([^\"]*)\" error message")
    public void shouldBeToShowErrorMessage(String errorMessage) {
        assertTrue(objLogin.shouldBeToShowUserIdErrorMessageAs(errorMessage),
                MessageFormat.format("Should be to show User Id error message as ''{0}''",
                        errorMessage));
    }

    @Then("^[a-zA-Z].* saw error message as below")
    public void shouldBeToShowErrorMessage(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        assertTrue(objLogin.shouldBeToShowUserIdErrorMessageAs(data.get(0).get(0)),
                MessageFormat.format("Should be to show User Id error message as ''{0}''",
                        data.get(0).get(0)));
    }

    @Then("^[a-zA-Z].* see error message as below")
    public void seeErrorMessage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();
        assertTrue(objLogin.shouldBeToShowUserIdErrorMessageAs(data.get(0).get("errorMessage")),
                MessageFormat.format("Should be to show User Id error message as ''{0}''",
                        data.get(0).get("errorMessage")));
    }

    @Then("^[a-zA-Z].* should be to show <errorMessage> error message")
    public void getErrorMessage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();
        assertTrue(objLogin.shouldBeToShowUserIdErrorMessageAs(data.get(0).get("errorMessage")),
                MessageFormat.format("Should be to show User Id error message as ''{0}''",
                        data.get(0).get("errorMessage")));
    }
}

