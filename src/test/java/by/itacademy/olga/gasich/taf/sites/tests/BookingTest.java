package by.itacademy.olga.gasich.taf.sites.tests;

import by.itacademy.olga.gasich.taf.sites.pages.BookingPage;
import by.itacademy.olga.gasich.taf.sites.steps.BookingStep;
import by.itacademy.olga.gasich.taf.sites.utils.Util;
import org.junit.jupiter.api.AfterEach;
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

        step.dontFillEmailFormAndSubmit("");
    }

    @Test
    public void testFillFormWithInvalidEmail() {

        step.fillEmailFormAndSubmit(Util.generatePassword());
    }

    @Test
    public void testFillFormWithValidEmailAndEmptyPassword() {

        step.fillLoginFormWithEmptyPasswordsAndSubmit(Util.generateEmail(), "");
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        step.fillLoginFormWithInvalidNewPasswordAndSubmit(Util.generateEmail(), Util.generatePassword());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
