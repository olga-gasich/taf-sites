package by.itacademy.olga.gasich.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingTest {

    ChromeDriver driver;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-cache");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.booking.com/");
    }

    @Test
    public void testFillFormWithEmptyEmail() {

        BookingPage page = new BookingPage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSignInOrRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(page.btnSignInOrRegisterXpath)));
        btnSignInOrRegister.click();

        WebElement btnContinueWithEmail = driver.findElement(By.xpath(page.btnContinueWithEmailXpath));
        btnContinueWithEmail.click();
    }

    @Test
    public void testFillFormWithInvalidEmail() {

        BookingPage page = new BookingPage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSignInOrRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(page.btnSignInOrRegisterXpath)));
        btnSignInOrRegister.click();

        WebElement inputEmailAddress = driver.findElement(By.xpath(page.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("test@gmail");

        WebElement btnContinueWithEmail = driver.findElement(By.xpath(page.btnContinueWithEmailXpath));
        btnContinueWithEmail.click();
    }

    @Test
    public void testFillFormWithValidEmail() {

        BookingPage page = new BookingPage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSignInOrRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(page.btnSignInOrRegisterXpath)));
        btnSignInOrRegister.click();

        WebElement inputEmailAddress = driver.findElement(By.xpath(page.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("test@gmail.com");

        WebElement btnContinueWithEmail = driver.findElement(By.xpath(page.btnContinueWithEmailXpath));
        btnContinueWithEmail.click();
    }

    @Test
    public void testFillFormWithValidEmailAndEmptyPassword() {

        BookingPage page = new BookingPage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSignInOrRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(page.btnSignInOrRegisterXpath)));
        btnSignInOrRegister.click();

        WebElement inputEmailAddress = driver.findElement(By.xpath(page.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("test@gmail.com");

        WebElement btnContinueWithEmail = driver.findElement(By.xpath(page.btnContinueWithEmailXpath));
        btnContinueWithEmail.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSubmit = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(page.btnSubmitXpath)));
        btnSubmit.click();
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        BookingPage page = new BookingPage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSignInOrRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(page.btnSignInOrRegisterXpath)));
        btnSignInOrRegister.click();

        WebElement inputEmailAddress = driver.findElement(By.xpath(page.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("test@gmail.com");

        WebElement btnContinueWithEmail = driver.findElement(By.xpath(page.btnContinueWithEmailXpath));
        btnContinueWithEmail.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputPsw = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(page.inputPswXpath)));
        inputPsw.sendKeys("123456");

        WebElement btnSubmit = driver.findElement(By.xpath(page.btnSubmitXpath));
        btnSubmit.click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
