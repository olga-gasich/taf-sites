package by.itacademy.olga.gasich.taf.sites.tests;

import by.itacademy.olga.gasich.taf.sites.pages.BookingPage;
import by.itacademy.olga.gasich.taf.sites.steps.BookingStep;
import by.itacademy.olga.gasich.taf.sites.utils.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookingTest {

    ChromeDriver driver;
    BookingPage page;
    BookingStep step;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-cache");
        driver = new ChromeDriver(chromeOptions);
        page = new BookingPage(driver);
        step = new BookingStep(driver);
        driver.manage().window().maximize();
        page.openBaseURL();
    }

    @Test
    public void testFillFormWithEmptyEmail() {

        step.fillEmailFormAndSubmit("");
        Assertions.assertEquals("Введите электронный адрес", page.getEmptyEmailAddressError());
    }

    @Test
    public void testFillFormWithInvalidEmail() {

        step.fillEmailFormAndSubmit(Util.generatePassword());
        Assertions.assertEquals("Проверьте правильность ввода.", page.getInvalidEmailAddressError());
    }

    @Test
    public void testFillFormWithValidEmailAndEmptyPassword() {

        step.fillLoginFormAndSubmit(Util.generateEmail(), "");
        Assertions.assertEquals("Введите новый пароль.", page.getEmptyPswError());
        Assertions.assertEquals("Введите пароль еще раз", page.getEmptyConfirmPswError());
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        step.fillLoginFormAndSubmit(Util.generateEmail(), Util.generatePassword());
        Assertions.assertEquals("Пароль должен содержать как минимум одну заглавную букву", page.getInvalidPswError());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
