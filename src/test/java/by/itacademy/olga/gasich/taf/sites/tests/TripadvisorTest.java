package by.itacademy.olga.gasich.taf.sites.tests;

import by.itacademy.olga.gasich.taf.sites.pages.TripadvisorPage;
import by.itacademy.olga.gasich.taf.sites.steps.TripadvisorStep;
import by.itacademy.olga.gasich.taf.sites.utils.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TripadvisorTest {

    ChromeDriver driver;
    TripadvisorPage page;
    TripadvisorStep step;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        page = new TripadvisorPage(driver);
        step = new TripadvisorStep(driver);
        driver.manage().window().maximize();
        page.openBaseURL();
    }

    @Test
    public void testFillFormWithEmptyEmailAndPassword() {

        step.fillLoginFormAndSubmit("", "");
        Assertions.assertEquals("E-mail address is required", page.getEmptyEmailError());
    }

    @Test
    public void testFillFormWithInvalidEmail() {

        step.fillLoginFormAndSubmit(Util.generatePassword(), "");
        Assertions.assertEquals("E-mail address is either invalid or starts with a generic alias to which we cannot send.", page.getInvalidEmailError());
    }

    @Test
    public void testFillFormWithValidEmailAndEmptyPassword() {

        step.fillLoginFormAndSubmit(Util.generateEmail(), "");
        Assertions.assertEquals("Your password must be at least 10 characters. Please try again.", page.getEmptyPswError());
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        step.fillLoginFormAndSubmit(Util.generateEmail(), Util.generatePassword());
        Assertions.assertEquals("Either your email or password was incorrect. Please try again or click the \"Forgot password?\" link below.", page.getInvalidEmailOrPswError());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
