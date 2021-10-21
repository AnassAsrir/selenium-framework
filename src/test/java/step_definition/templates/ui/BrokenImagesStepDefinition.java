package step_definition.templates.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static modules.Hooks.driver;
import static org.junit.Assert.assertTrue;
import static utils.Images.*;

public class BrokenImagesStepDefinition {
    WebElement image;
    @When("image {int}")
    public void imageImageIndex(int index) {
        image = driver.findElement(By.cssSelector("#content > div > img:nth-child("+index+")"));
    }

    @Then("if broken test should fail")
    public void ifBrokenTestShouldFail() {
        assertTrue(!isImageBroken(image));
    }
}
