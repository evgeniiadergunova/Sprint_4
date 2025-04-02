package hw_sprint4.questions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Questions {

    private WebDriver driver;
    private By listOfQuestions = By.className("accordion__button");
    //private By listOfAnswers = By.xpath(".//div[@class='accordion__panel']");


    public Questions(WebDriver driver){
        this.driver = driver;
    }




    public List<String> openDropdownQuestionsAndCheckAnswers() {
        List<WebElement> questions = driver.findElements(listOfQuestions);
        List<String> answers = new ArrayList<>();

        WebElement firstQuestion = driver.findElement(By.xpath(".//div[text()= 'Сколько это стоит? И как оплатить?']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", firstQuestion);

        for (WebElement question : questions) {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(question));
            if (question.isDisplayed() && question.isEnabled()) {
                question.click();
                String answerText = question.findElement(By.className("accordion__panel")).getText();
                answers.add(answerText);

            }
        }

        return answers;


    }
}
