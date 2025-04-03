package hw_sprint4.questions.orderPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPage {

    private static final By RENT_HEADER = By.className("Order_Header__BZXOb");
    private static final By DATE_OF_ORDER = By.xpath("//input[contains(@placeholder,'* Когда привезти самокат')]");
    private static final By RENT_DATES = By.xpath("//div[contains(@placeholder,'* Срок аренды')]");
    private static final By SAMOKAT_COLOR_BLACK = By.id("black");
    private static final By SAMOKAT_COLOR_GREY = By.id("grey");
    private static final By COMMENT_FOR_COURIER = By.xpath("//div[contains(@placeholder,'Комментарий для курьера')]");
    private static final By ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By POP_UP_HEADER = By.className("Order_ModalHeader__3FDaJ");
    private static final By BUTTON_YES = By.xpath(".//button[text()='Да']");
    private WebDriver driver;

    public RentPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillInOrderDetils(String date, String rentDatesDropdownItem, String commentForCourier ) {
        driver.findElement(DATE_OF_ORDER).sendKeys(date);
        driver.findElement(DATE_OF_ORDER).sendKeys(Keys.ENTER);
        driver.findElement(RENT_DATES).click();
        driver.findElement(By.xpath(".//div[contains(@text(), '" + rentDatesDropdownItem + "')]")).click();
        driver.findElement(SAMOKAT_COLOR_BLACK).click();
        driver.findElement(COMMENT_FOR_COURIER).sendKeys(commentForCourier);


    }

    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
    }

    public void checkHeader() {
        driver.findElement(RENT_HEADER).isDisplayed();

    }

    public void checkPopUpHeader() {
        driver.findElement(POP_UP_HEADER).isDisplayed();
    }

    public void clickButtonYes() {
        driver.findElement(BUTTON_YES).click();

    }


}
