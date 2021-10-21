package modules.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationFormPage {

    @FindBy(id="username")
    static WebElement textboxUsername;

    @FindBy(id="password")
    static WebElement textboxPassword;

    @FindBy(className = "radius")
    public static WebElement buttonLogin;

    @FindBy(id = "flash")
    public static WebElement textMessage;

    public static void setCredentials(String username, String password){
        textboxUsername.clear();
        textboxUsername.sendKeys(username);
        textboxPassword.clear();
        textboxPassword.sendKeys(password);
    }
}
