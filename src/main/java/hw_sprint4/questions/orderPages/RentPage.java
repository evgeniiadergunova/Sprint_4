package hw_sprint4.questions.orderPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

    public class RentPage {

        private static final By RENT_HEADER = By.className("Order_Header__BZXOb");
        private static final By DATE_OF_ORDER = By.xpath("//input[contains(@placeholder,'* Когда привезти самокат')]");
        private static final By RENT_DATES_DROPDOWN = By.cssSelector(".Dropdown-root");
        private static final By COMMENT_FOR_COURIER = By.xpath("//input[contains(@placeholder,'Комментарий для курьера')]");
        private static final By ORDER_BUTTON = By.cssSelector("[class*='Order_Content'] > [class*='Order_Buttons'] button:nth-child(2)");
        private static final By POPUP = By.cssSelector("[class*='Order_Modal']");
        private final WebDriver driver;

        public RentPage(WebDriver driver){
            this.driver = driver;
        }

        public void start(String date, String rentDatesDropdownItem, String scooterColor, String commentForCourier) {
            this.fillInOrderDetails(date, rentDatesDropdownItem, scooterColor, commentForCourier);
        }

        public void fillInOrderDetails(String date, String rentDatesDropdownItem, String scooterColor, String commentForCourier) {
            driver.findElement(DATE_OF_ORDER).sendKeys(date);
            driver.findElement(DATE_OF_ORDER).sendKeys(Keys.ENTER);

            driver.findElement(RENT_DATES_DROPDOWN).click();
            driver.findElement(By.xpath("//*[text()='" + rentDatesDropdownItem + "']")).click();

            driver.findElement(By.id(getIdForScooterColor(scooterColor))).click();
            driver.findElement(COMMENT_FOR_COURIER).sendKeys(commentForCourier);

            this.clickOrderButton();
            this.checkPopUpHeader();
            this.clickButtonYes();
        }

        private String getIdForScooterColor(String stringColor) {
            switch (stringColor) {
                case "чёрный жемчуг":
                    return "black";
                case "серая безысходность":
                    return "grey";
            }

            return "";
        }

        public void clickOrderButton() {
            driver.findElement(ORDER_BUTTON).click();
        }

        public boolean checkHeader() {
            return driver.findElement(RENT_HEADER).isDisplayed();
        }

        public void checkPopUpHeader() {
            driver.findElement(POPUP).isDisplayed();
        }

        public void clickButtonYes() {
            driver.findElement(By.cssSelector("[class*='Order_Modal__'] [class*='Order_Buttons'] button:nth-child(2)")).click();
        }
    }
