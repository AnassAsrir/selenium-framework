package step_definition.templates.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static modules.Hooks.driver;
import static org.junit.Assert.*;

public class AddRemoveElementsStepDefinition {
    int initialNbElements,finalNbElements;

    @When("user clicks once the button Add Element")
    public void userClicksOnceTheButtonAddElement() {
        driver.findElement(By.cssSelector("#content > div > button")).click();
    }

    @Then("one new element is added on the page")
    public void oneNewElementIsAddedOnThePage() {
        finalNbElements = driver.findElements(By.cssSelector("#elements > button")).size();
        assertEquals(1,finalNbElements);
    }

    @When("user clicks multiple times the button Add Element")
    public void userClicksMultipleTimesTheButtonAddElement() {
        for(int i=0; i<4; i++){
            driver.findElement(By.cssSelector("#content > div > button")).click();
        }
    }

    @Then("multiple elements are added on the page")
    public void multipleElementsAreAddedOnThePage() {
        finalNbElements = driver.findElements(By.cssSelector("#elements > button")).size();
        assertEquals(4,finalNbElements);
    }

    @When("user deletes one element")
    public void userDeletesOneElement() {
        initialNbElements = driver.findElements(By.cssSelector("#elements > button")).size();
        driver.findElement(By.cssSelector("#elements > button:nth-child(2)")).click();
    }

    @Then("only one element is deleted")
    public void onlyOneElementIsDeleted() {
        finalNbElements = driver.findElements(By.cssSelector("#elements > button")).size();
        assertEquals(initialNbElements-1,finalNbElements);
    }

    @When("user deletes all elements")
    public void userDeletesAllElements() {
        initialNbElements = driver.findElements(By.cssSelector("#elements > button")).size();
        for (int i=initialNbElements; i>0; i--){
            driver.findElement(By.cssSelector("#elements > button:nth-child("+i+")")).click();
        }
    }

    @Then("all elements are deleted")
    public void allElementsAreDeleted() {
        finalNbElements = driver.findElements(By.cssSelector("#elements > button")).size();
        assertEquals(0,finalNbElements);
    }
}
