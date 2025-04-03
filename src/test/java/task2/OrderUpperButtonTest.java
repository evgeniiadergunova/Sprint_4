package task2;

import hw_sprint4.questions.orderPages.OrderPage;
import hw_sprint4.questions.orderPages.RentPage;
import hw_sprint4.questions.orderPages.StartPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderUpperButtonTest {

        private WebDriver driver;
        private final String name;
        private final String surname;
        private final String address;
        private final String phoneNumber;
        private final int metroStationIndex;

        public OrderUpperButtonTest(String name, String surname, String address, int metroStationIndex, String phoneNumber) {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.metroStationIndex = metroStationIndex;
            this.phoneNumber = phoneNumber;
        }


        @Before
        public void setupWebDriver() {
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");
            driver.findElement(By.id("rcc-confirm-button")).click();
        }

        @Parameterized.Parameters
        public static Object[][] orderTestData() {
            return new Object[][] {
                    {"Мелисса", "Фрайхайт", "Москва, улица печали 31", 23, "79501111113" },
                    {"Мария", "Иванова", "Москва", 15, "+79021234567"},
            };
        }

        @Test
        public void orderUpperButtonTest() {
            OrderPage orderPage = new OrderPage(driver);
            StartPage startPage = new StartPage(driver);
            RentPage rentPage = new RentPage(driver);
            startPage.clickOrderUpperButton();
            orderPage.checkOrderHeader();
            orderPage.fillInOrderForm(name, surname, address, metroStationIndex, phoneNumber);

            orderPage.clickNextButton();
            rentPage.checkHeader();



        }



        @After
        public void teardown() {
            if (driver != null) {
                driver.quit(); // Закрываем браузер после окончания всех тестов
            }
        }




}

