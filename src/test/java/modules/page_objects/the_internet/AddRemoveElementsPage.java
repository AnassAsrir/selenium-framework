package modules.page_objects.the_internet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddRemoveElementsPage {
    @FindBy(css="#content > div > button")
    static WebElement buttonAdd;

    @FindBy(css = "#elements > button")
    public static WebElement buttonDelete;

    public static void addElement(){
        buttonAdd.click();
    }

    public static void deleteElement(){
        buttonDelete.click();
    }
}
