package by.itacademy.olga.gasich.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PizzatempoTest {

    ChromeDriver driver;
    PizzatempoPage page;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.pizzatempo.by/");
        page = new PizzatempoPage(driver);
    }

    @Test
    public void testFillFormWithEmptyEmailAndPassword() {

        page.clickBtnSearch();
    }

    @Test
    public void testFillFormWithInvalidEmail() {

        page.fillInputEmailAddress(Util.generatePassword(18));
        page.clickBtnSearch();
    }

    @Test
    public void testFillFormWithEmptyEmailAndSomePassword() {

        page.fillInputPsw(Util.generatePassword(6));
        page.clickBtnSearch();
    }

    @Test
    public void testFillFormWithValidEmailAndEmptyPassword() {

        page.fillInputEmailAddress(Util.generateEmail(14));
        page.clickBtnSearch();
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        page.fillInputEmailAddress(Util.generateEmail(17));
        page.fillInputPsw(Util.generatePassword(10));
        page.clickBtnSearch();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
