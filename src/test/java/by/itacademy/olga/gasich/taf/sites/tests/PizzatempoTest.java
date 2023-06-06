package by.itacademy.olga.gasich.taf.sites.tests;

import by.itacademy.olga.gasich.taf.sites.pages.PizzatempoPage;
import by.itacademy.olga.gasich.taf.sites.steps.PizzatempoStep;
import by.itacademy.olga.gasich.taf.sites.utils.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals("Заполните форму", page.getAlert());
    }

    @Test
    public void testFillFormWithInvalidEmail() {

        step.fillLoginFormAndSubmit(Util.generatePassword(),"");
        Assertions.assertEquals("Заполните форму", page.getAlert());
    }

    @Test
    public void testFillFormWithEmptyEmailAndSomePassword() {

        step.fillLoginFormAndSubmit("",Util.generatePassword());
        Assertions.assertEquals("Заполните форму", page.getAlert());
    }

    @Test
    public void testFillFormWithValidEmailAndEmptyPassword() {

        step.fillLoginFormAndSubmit(Util.generateEmail(),"");
        Assertions.assertEquals("Заполните форму", page.getAlert());
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        step.fillLoginFormAndSubmit(Util.generateEmail(),Util.generatePassword());
        Assertions.assertEquals("Неверно указано имя пользователя или пароль.\n" +
                "Ok", page.getError());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
