package by.itacademy.olga.gasich.taf.sites.tests;

import by.itacademy.olga.gasich.taf.sites.pages.DominosPage;
import by.itacademy.olga.gasich.taf.sites.steps.DominosStep;
import by.itacademy.olga.gasich.taf.sites.utils.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DominosTest {

    ChromeDriver driver;
    DominosPage page;
    DominosStep step;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-cache");
        driver = new ChromeDriver(chromeOptions);
        page = new DominosPage(driver);
        step = new DominosStep(driver);
        driver.manage().window().maximize();
        page.openBaseURL();
    }

    @Test
    public void testFillFormWithInvalidEmailAndSomePassword() {

        step.fillLoginFormAndSubmitWithIncorrectData(Util.generatePassword(), Util.generatePassword());
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        step.fillLoginFormAndSubmitWithCorrectData(Util.generateEmail(), Util.generatePassword());
    }

    @AfterEach
    public void tearDown() {
    driver.quit();
    }
}
