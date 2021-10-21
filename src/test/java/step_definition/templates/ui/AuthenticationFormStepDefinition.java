package step_definition.templates.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
}
