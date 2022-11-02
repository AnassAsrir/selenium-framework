package step_definition.the_internet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import utils.PropertiesFile;

import java.util.HashMap;

import static modules.Hooks.driver;

public class CommonSteps {
    private static HashMap<String, String> configurationMap = PropertiesFile.read("src/test/resources/environment/the-internet.properties");
    static String baseUrl = configurationMap.get("baseUrl");
    @Given("user lands on the The Internet Herokuapp application")
    public void userLandsOnTheTheInternetHerokuappApplication() {
        driver.navigate().to(baseUrl);
    }

    @And("user opens the {string} page")
    public void userOpensThePage(String link) {
        driver.findElement(By.linkText(link)).click();
    }
}
