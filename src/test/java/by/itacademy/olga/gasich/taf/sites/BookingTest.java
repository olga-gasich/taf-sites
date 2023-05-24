package by.itacademy.olga.gasich.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookingTest {

    ChromeDriver driver;
    BookingPage page;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-cache");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.booking.com/");
        page = new BookingPage(driver);
    }

    @Test
    public void testFillFormWithEmptyEmail() {

        page.clickBtnSignInOrRegister();
        page.clickBtnContinueWithEmail();
    }

    @Test
    public void testFillFormWithInvalidEmail() {

        page.clickBtnSignInOrRegister();
        page.fillInputEmailAddress(Util.generatePassword(10));
        page.clickBtnContinueWithEmail();
    }

    @Test
    public void testFillFormWithValidEmail() {

        page.clickBtnSignInOrRegister();
        page.fillInputEmailAddress(Util.generateEmail(15));
        page.clickBtnContinueWithEmail();
    }

    @Test
    public void testFillFormWithValidEmailAndEmptyPassword() {

        page.clickBtnSignInOrRegister();
        page.fillInputEmailAddress(Util.generateEmail(15));
        page.clickBtnContinueWithEmail();
        page.clickBtnSubmit();
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        page.clickBtnSignInOrRegister();
        page.fillInputEmailAddress(Util.generateEmail(15));
        page.clickBtnContinueWithEmail();
        page.fillInputPsw(Util.generatePassword(10));
        page.clickBtnSubmit();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
