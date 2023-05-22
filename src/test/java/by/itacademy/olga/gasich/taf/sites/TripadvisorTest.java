package by.itacademy.olga.gasich.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TripadvisorTest {

    ChromeDriver driver;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.tripadvisor.com/");
    }

    @Test
    public void testFillFormWithEmptyEmailAndSomePassword() {

        TripadvisorPage page = new TripadvisorPage();

        WebElement btnSignIn = driver.findElement(By.xpath(page.btnSignInXpath));
        btnSignIn.click();

        driver.switchTo().frame(driver.findElement(By.cssSelector(page.iframeCsspath)));
        WebElement btnContinueWithEmail = driver.findElement(By.xpath(page.btnContinueWithEmailXpath));
        btnContinueWithEmail.click();

        WebElement inputPsw = driver.findElement(By.xpath(page.inputPswXpath));
        inputPsw.sendKeys("123456");

        WebElement btnSubmit = driver.findElement(By.xpath(page.btnSubmitXpath));
        btnSubmit.click();
    }

    @Test
    public void testFillFormWithInvalidEmail() {

        TripadvisorPage page = new TripadvisorPage();

        WebElement btnSignIn = driver.findElement(By.xpath(page.btnSignInXpath));
        btnSignIn.click();

        driver.switchTo().frame(driver.findElement(By.cssSelector(page.iframeCsspath)));
        WebElement btnContinueWithEmail = driver.findElement(By.xpath(page.btnContinueWithEmailXpath));
        btnContinueWithEmail.click();

        WebElement inputEmailAddress = driver.findElement(By.xpath(page.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("olagasich@@gmail.com");

        WebElement btnSubmit = driver.findElement(By.xpath(page.btnSubmitXpath));
        btnSubmit.click();
    }

    @Test
    public void testFillFormWithValidEmailAndEmptyPassword() {

        TripadvisorPage page = new TripadvisorPage();

        WebElement btnSignIn = driver.findElement(By.xpath(page.btnSignInXpath));
        btnSignIn.click();

        driver.switchTo().frame(driver.findElement(By.cssSelector(page.iframeCsspath)));
        WebElement btnContinueWithEmail = driver.findElement(By.xpath(page.btnContinueWithEmailXpath));
        btnContinueWithEmail.click();

        WebElement inputEmailAddress = driver.findElement(By.xpath(page.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("olagasich@gmail.com");

        WebElement btnSubmit = driver.findElement(By.xpath(page.btnSubmitXpath));
        btnSubmit.click();
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        TripadvisorPage page = new TripadvisorPage();

        WebElement btnSignIn = driver.findElement(By.xpath(page.btnSignInXpath));
        btnSignIn.click();

        driver.switchTo().frame(driver.findElement(By.cssSelector(page.iframeCsspath)));
        WebElement btnContinueWithEmail = driver.findElement(By.xpath(page.btnContinueWithEmailXpath));
        btnContinueWithEmail.click();

        WebElement inputEmailAddress = driver.findElement(By.xpath(page.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("olagasich@gmail.com");

        WebElement inputPsw = driver.findElement(By.xpath(page.inputPswXpath));
        inputPsw.sendKeys("123456");

        WebElement btnSubmit = driver.findElement(By.xpath(page.btnSubmitXpath));
        btnSubmit.click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
