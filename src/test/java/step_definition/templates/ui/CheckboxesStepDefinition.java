package step_definition.templates.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static modules.Hooks.driver;
import static org.junit.Assert.*;

public class CheckboxesStepDefinition {
    WebElement checkbox;

    @When("user checks box {int}")
    public void userChecksBox(int arg0) {
        checkbox = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child("+arg0+")"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @Then("checkbox {int} is checked")
    public void checkboxIsChecked(int arg0) {
        checkbox = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child("+arg0+")"));
        assertTrue(checkbox.isSelected());
    }
}
