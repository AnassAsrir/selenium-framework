package step_definition.templates.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import utils.PropertiesFile;

import java.util.HashMap;

import static modules.Hooks.driver;

public class HomePageStepDefinition {
    private static HashMap<String, String> configurationMap = PropertiesFile.read("src/test/resources/environment/config.properties");
    static String baseUrl = configurationMap.get("baseUrl");

    @Given("user lands on the The Internet Herokuapp application")
    public void userLandsOnTheTheInternetHerokuappApplication() {
        driver.navigate().to(baseUrl);
    }

    @And("user opens the {string} page")
    public void userOpensThePage(String arg0) {
        driver.findElement(By.linkText(arg0)).click();
    }
}
