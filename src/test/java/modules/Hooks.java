package modules;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import modules.page_objects.the_internet.AddRemoveElementsPage;
import modules.page_objects.the_internet.AuthenticationFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesFile;

import java.io.IOException;
import java.util.HashMap;

import static utils.BrowserFactory.getFactoryDriver;

public class Hooks {
    public static WebDriver driver;
    private final AuthenticationFormPage authenticationPageObject = new AuthenticationFormPage();
    private final AddRemoveElementsPage addRemoveElementsPageObject = new AddRemoveElementsPage();
    private static final HashMap<String, String> configurationMap = PropertiesFile.read("src/test/resources/environment/config.properties");
    static String webBrowserType = configurationMap.get("browser");
    static String baseUri = configurationMap.get("baseUri");

    @Before()
    public void cleanUp() throws IOException {
        Runtime rt = Runtime.getRuntime();
        switch (webBrowserType) {
            case "chrome":
                break;
            case "ie":
                break;
            case "firefox":
                break;
            case "edge-legacy":
            default:
                Process pr = rt.exec("taskkill /IM chromedriver.exe /F");
                break;
        }
    }

    @Before("@ui")
    public void setUpDriver(){
        driver = getFactoryDriver();
        PageFactory.initElements(driver, authenticationPageObject);
        PageFactory.initElements(driver, addRemoveElementsPageObject);

    }

    @After("@ui")
    public void tearDownDriver(){
        driver.quit();
    }

    @Before("@api")
    public void initiateWebServiceCall(){
        RestAssured.baseURI = baseUri;
    }
}
