
package hw_sprint4.questions.orderPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class OrderPage {

        private final By ORDER_HEADER = By.className("Order_Header__BZXOb");
        private final By NAME_FIELD = By.xpath("//input[contains(@placeholder,'* Имя')]");
        private final By SURNAME_FIELD = By.xpath("//input[contains(@placeholder,'* Фамилия')]");
        private final By ADDRESS = By.xpath("//input[contains(@placeholder,'* Адрес: куда привезти заказ')]");
        private final By METRO_STATION_BLOCK = By.xpath("//input[contains(@placeholder,'* Станция метро')]");
        private final By PHONE_NUMBER = By.xpath("//input[contains(@placeholder,'* Телефон: на него позвонит курьер')]");
        private final By NEXT_BUTTON = By.cssSelector("[class*='Order_NextButton'] button");
        private final WebDriver driver;

        public OrderPage(WebDriver driver){
            this.driver = driver;
        }

        public void start(String name, String surname, String address, int metroStationIndex, String proneNumber) {
            this.checkOrderHeader();
            this.fillInOrderForm(name, surname, address, metroStationIndex, proneNumber);
            this.clickNextButton();
        }

        public void checkOrderHeader() {
            driver.findElement(ORDER_HEADER).isDisplayed();
        }

        public void fillInOrderForm(String name, String surname, String address, int metroStationIndex, String proneNumber) {
            driver.findElement(NAME_FIELD).sendKeys(name);
            driver.findElement(SURNAME_FIELD).sendKeys(surname);
            driver.findElement(ADDRESS).sendKeys(address);
            driver.findElement(METRO_STATION_BLOCK).click();
            var optionItem = String.format(".select-search__options button[value='%s']", metroStationIndex);
            driver.findElement(By.cssSelector(optionItem)).click();
            driver.findElement(PHONE_NUMBER).sendKeys(proneNumber);
        }



        public void clickNextButton() {
            driver.findElement(NEXT_BUTTON).click();
        }
    }


