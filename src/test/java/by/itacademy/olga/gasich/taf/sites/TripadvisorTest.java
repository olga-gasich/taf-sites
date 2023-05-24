package by.itacademy.olga.gasich.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TripadvisorTest {

    ChromeDriver driver;
    TripadvisorPage page;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.tripadvisor.com/");
        page = new TripadvisorPage(driver);
    }

    @Test
    public void testFillFormWithEmptyEmailAndPassword() {

        page.clickBtnSignIn();
        page.clickBtnContinueWithEmail();
        page.clickBtnSubmit();
    }

    @Test
    public void testFillFormWithInvalidEmail() {

        page.clickBtnSignIn();
        page.clickBtnContinueWithEmail();
        page.fillInputEmailAddress(Util.generatePassword(10));
        page.clickBtnSubmit();
    }

    @Test
    public void testFillFormWithValidEmailAndEmptyPassword() {

        page.clickBtnSignIn();
        page.clickBtnContinueWithEmail();
        page.fillInputEmailAddress(Util.generateEmail(15));
        page.clickBtnSubmit();
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        page.clickBtnSignIn();
        page.clickBtnContinueWithEmail();
        page.fillInputEmailAddress(Util.generateEmail(16));
        page.fillInputPsw(Util.generatePassword(8));
        page.clickBtnSubmit();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
