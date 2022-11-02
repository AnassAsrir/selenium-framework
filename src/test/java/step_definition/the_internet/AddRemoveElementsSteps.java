package step_definition.the_internet;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static modules.page_objects.the_internet.AddRemoveElementsPage.*;
import static org.junit.Assert.assertTrue;

public class AddRemoveElementsSteps {
    @When("user clicks once the button Add Element")
    public void userClicksOnceTheButtonAddElement() {
        addElement();
    }

    @Then("one new element is added on the page")
    public void oneNewElementIsAddedOnThePage() {
        assertTrue(buttonDelete.isDisplayed());
    }
}
