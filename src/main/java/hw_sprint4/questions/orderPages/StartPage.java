package hw_sprint4.questions.orderPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage {

    private final By ORDER_UPPER_BUTTON = By.cssSelector("[class*='Header_Nav'] button:nth-child(1)");

    private final By ORDER_BOTTOM_BUTTON = By.cssSelector("[class*='Home_FinishButton'] button");

    private final WebDriver driver;

    public StartPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean clickOrderUpperButton(String button) {
        var buttonBy = getByForDifferentButtons(button);
        if (buttonBy == null) {
            return false;
        }

        driver.findElement(buttonBy).click();
        return true;
    }

    private By getByForDifferentButtons(String name) {
        switch (name) {
            case "top":
                return ORDER_UPPER_BUTTON;
            case "bottom":
                return ORDER_BOTTOM_BUTTON;
        }

        return null;
    }
}
