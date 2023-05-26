package by.itacademy.olga.gasich.taf.sites;

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

        step.fillLoginFormAndSubmit("", "");
    }

    @Test
    public void testFillFormWithInvalidEmail() {

        step.fillLoginFormAndSubmit(Util.generatePassword(), "");
    }

    @Test
    public void testFillFormWithValidEmail() {

        step.fillLoginFormAndSubmit(Util.generateEmail(), "");
    }

    @Test
    public void testFillFormWithValidEmailAndEmptyPassword() {

        step.fillLoginFormAndSubmit(Util.generateEmail(), "");
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        step.fillLoginFormAndSubmit(Util.generateEmail(), Util.generatePassword());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
