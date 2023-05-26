package by.itacademy.olga.gasich.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PizzatempoTest {

    ChromeDriver driver;
    PizzatempoPage page;
    PizzatempoStep step;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        page = new PizzatempoPage(driver);
        step = new PizzatempoStep(driver);
        driver.manage().window().maximize();
        page.openBaseURL();
    }

    @Test
    public void testFillFormWithEmptyEmailAndPassword() {

        step.fillLoginFormAndSubmit("","");
    }

    @Test
    public void testFillFormWithInvalidEmail() {

        step.fillLoginFormAndSubmit(Util.generatePassword(),"");
    }

    @Test
    public void testFillFormWithEmptyEmailAndSomePassword() {

        step.fillLoginFormAndSubmit("",Util.generatePassword());
    }

    @Test
    public void testFillFormWithValidEmailAndEmptyPassword() {

        step.fillLoginFormAndSubmit(Util.generateEmail(),"");
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        step.fillLoginFormAndSubmit(Util.generateEmail(),Util.generatePassword());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
