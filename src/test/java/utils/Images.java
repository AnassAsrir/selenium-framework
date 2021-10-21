package utils;

import org.openqa.selenium.WebElement;

public class Images {

    public static boolean isImageBroken(WebElement image) {
        return image.getAttribute("naturalWidth").equals("0");
    }
}
