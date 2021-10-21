package step_definition.templates.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static modules.Hooks.driver;
import static org.junit.Assert.*;

public class DropdownStepdefinition {
    WebElement dropdown;
    Select selectedValue;
    String selectedText;

    String getSelectedText(){
        dropdown = driver.findElement(By.id("dropdown"));
        selectedValue = new Select(dropdown);
        selectedText = selectedValue.getFirstSelectedOption().getText();
        return selectedText;
    }

    @Given("initially that no option is selected")
    public void initiallyThatNoOptionIsSelected() {
        assertEquals("Please select an option",getSelectedText());
    }

    @When("user selects option {int}")
    public void userSelectsOption(int arg0) {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByValue(String.valueOf(arg0));
    }

    @Then("option {int} is selected")
    public void optionIsSelected(int arg0) {
        assertTrue(getSelectedText().contains(String.valueOf(arg0)));
    }
}
