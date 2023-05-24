package by.itacademy.olga.gasich.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DominosTest {

    ChromeDriver driver;
    DominosPage page;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-cache");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://dominos.by/");
        page = new DominosPage(driver);
    }

    @Test
    public void testFillFormWithInvalidEmailAndSomePassword() {

        page.clickBtnCrossOnModal();
        page.clickBtnEnter();
        page.fillInputEmailAddress(Util.generateEmail(15));
        page.fillInputPsw(Util.generatePassword(10));
        page.clickBtnSubmit();
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        page.clickBtnCrossOnModal();
        page.clickBtnEnter();
        page.fillInputEmailAddress(Util.generateEmail(15));
        page.fillInputPsw(Util.generatePassword(10));
        page.clickBtnSubmit();
    }

    @AfterEach
    public void tearDown() {
    driver.quit();
    }
}
