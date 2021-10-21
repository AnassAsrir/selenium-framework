package step_definition.templates.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static modules.Hooks.driver;
import static org.junit.Assert.assertEquals;

public class DragAndDropStepDefinition {
    String columnContent;

    @Given("{string} contains letter {string}")
    public void containsLetter(String columnKey, String columnValue) {
        WebElement column = driver.findElement(By.id(columnKey));
        columnContent = column.getText();
        assertEquals(columnValue,columnContent);
    }

    @When("user drags and drops {string} content into {string}")
    public void userDragsAndDropsContentInto(String arg0, String arg1) {
        WebElement from = driver.findElement(By.id(arg0));
        WebElement to = driver.findElement(By.id(arg1));
        Actions action = new Actions(driver);
        action.dragAndDrop(from,to).perform();
    }
}
