package hw_sprint4.questions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Questions {

    private WebDriver driver;
    public Questions(WebDriver driver){
        this.driver = driver;
    }


    public String openDropdownQuestionsAndCheckAnswers(int index, String question) {

        var questionXpath = String.format(".//div[text()= '%s']", question);
        var questionPanel = driver.findElement(By.xpath(questionXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionPanel);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(questionPanel));
        questionPanel.click();
        if (element.isDisplayed() && element.isEnabled()) {
            var elemId = String.format("accordion__panel-%s", index);
            var panel = driver.findElement(By.id(elemId));
            return panel.getText();
        }

        return "";
    }
}
