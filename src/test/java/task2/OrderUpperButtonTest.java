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
import task2.formData.OrderScooterFullTestData;
import task2.formData.OrderScooterRentInfoForm;
import task2.formData.OrderScooterWhoForm;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderUpperButtonTest {
    private WebDriver driver;
    private final OrderScooterWhoForm whoFormData;
    private final OrderScooterRentInfoForm rentInfoFormData;

    public OrderUpperButtonTest(OrderScooterFullTestData form) {
        this.whoFormData = form.getWhoFormData();
        this.rentInfoFormData = form.getRentInfoFormData();
    }

    @Before
    public void setupWebDriver() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.id("rcc-confirm-button")).click();
    }

    @Parameterized.Parameters
    public static OrderScooterFullTestData[] orderTestData() {
        var testData = new OrderScooterFullTestData[2];
        testData[0] = new OrderScooterFullTestData(
                new OrderScooterWhoForm("Мелисса", "Фрайхайт", "Москва, улица печали 31", 1, "79501111113"),
                new OrderScooterRentInfoForm("02.03.2025", "сутки", "чёрный жемчуг", "Test 1")
        );

        testData[1] = new OrderScooterFullTestData(
                new OrderScooterWhoForm("Мария", "Иванова", "Москва", 3, "+79021234567"),
                new OrderScooterRentInfoForm("08.03.2024", "двое суток", "серая безысходность", "Test 2")
        );

        return testData;
    }

    @Test
    public void orderUpperButtonTest() {
        var buttons = new String[] {"top", "bottom"};

        for (int i = 0; i < buttons.length; i++) {
            StartPage startPage = new StartPage(driver);
            var startResult =  startPage.clickOrderUpperButton(buttons[i]);
            assertTrue(startResult);

            OrderPage orderPage = new OrderPage(driver);
            orderPage.start(whoFormData.name, whoFormData.surname, whoFormData.address, whoFormData.metroStationIndex, whoFormData.phoneNumber);

            RentPage rentPage = new RentPage(driver);

            //Проверяем, что первая форма прошла
            assertTrue(rentPage.checkHeader());

            rentPage.start(rentInfoFormData.date, rentInfoFormData.rentDatesDropdownItem, rentInfoFormData.scooterColor, rentInfoFormData.commentForCourier);
            orderPage.clickYesButton();
            assertTrue(orderPage.checkOrderConfirmed());
            if (i < buttons.length - 1) {
                driver.navigate().back();
            }




        }




    }



    @After
    public void teardown() {
        if (driver != null) {
            driver.quit(); // Закрываем браузер после окончания всех тестов
        }
    }
}

