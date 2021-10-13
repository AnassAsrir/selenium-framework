package utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    static WebDriver factoryDriver;
    private static final HashMap<String, String> configurationMap = PropertiesFile.read("src/test/resources/environment/config.properties");
    static String webBrowserType = configurationMap.get("browser");
    static boolean headless = Boolean.parseBoolean(configurationMap.get("isHeadless"));
    static String chromeDriver,firefoxDriver,IEDriver;

    public static WebDriver getFactoryDriver() {
        String driversPath = "src/test/resources/drivers/";
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")){
            chromeDriver = "macOs_drivers/chromedriver";
            firefoxDriver = "macOs_drivers/geckodriver";
            IEDriver = "macOs_drivers/IEDriverServer";
        } else if (osName.contains("windows")) {
            chromeDriver = "windows_drivers/chromedriver.exe";
            firefoxDriver = "windows_drivers/geckodriver.exe";
            IEDriver = "windows_drivers/IEDriverServer.exe";
        }
        // todo: add paths for linux

        switch (webBrowserType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", driversPath + chromeDriver);
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(headless);
                factoryDriver = new ChromeDriver(options);
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", driversPath + IEDriver);
                factoryDriver = new InternetExplorerDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", driversPath + firefoxDriver);
                factoryDriver = new FirefoxDriver();
                break;
            case "edge-legacy":
                //obsolete
                factoryDriver = new EdgeDriver();
            default:
                System.setProperty("webdriver.chrome.driver", driversPath + chromeDriver);
                factoryDriver = new ChromeDriver();
                break;
        }
        factoryDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return factoryDriver;
    }

}
