package step_definition.templates.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static modules.page_objects.AuthenticationFormPage.buttonLogin;
import static modules.page_objects.AuthenticationFormPage.setCredentials;

public class AuthenticationFormStepDefinition {
    String login,password;

    @When("I type {string} and {string}")
    public void iTypeAnd(String arg0, String arg1) {
        login = arg0;
        password = arg1;
        setCredentials(login,password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        buttonLogin.click();
    }

    @Then("the {string} should be displayed")
    public void theShouldBeDisplayed(String arg0) {

    }

    @When("I type loaded login data from external file")
    public void iTypeLoadedLoginDataFromExternalFile() throws IOException, InvalidFormatException {
        List<Map<String, String>> data = ExcelReader.getData("src/test/resources/data/login-data.xlsx", "Feuil1");
        String username = data.get(0).get("username");
        String password = data.get(0).get("password");
        setCredentials(username,password);
    }
}
