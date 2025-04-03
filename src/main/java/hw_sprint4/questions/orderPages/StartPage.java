package hw_sprint4.questions.orderPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage {

    private final By ORDER_UPPER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g']");
    private WebDriver driver;

    public StartPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOrderUpperButton() {
        driver.findElement(ORDER_UPPER_BUTTON).click();
    }
}
