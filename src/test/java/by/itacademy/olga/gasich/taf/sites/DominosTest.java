package by.itacademy.olga.gasich.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DominosTest {

    ChromeDriver driver;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-cache");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://dominos.by/");
    }

    @Test
    public void testFillFormWithInvalidEmailAndSomePassword() {

        DominosPage page = new DominosPage();

        WebElement btnCrossOnModal = driver.findElement(By.cssSelector(page.btnCrossOnModalCss));
        btnCrossOnModal.click();

        WebElement btnEnter = driver.findElement(By.xpath(page.btnEnterXpath));
        btnEnter.click();

        WebElement inputEmailAddress = driver.findElement(By.xpath(page.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("olagasich@gmail..com");

        WebElement inputPsw = driver.findElement(By.xpath(page.inputPswXpath));
        inputPsw.sendKeys("123456");

        WebElement btnSubmit = driver.findElement(By.xpath(page.btnSubmitXpath));
        btnSubmit.click();
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        DominosPage page = new DominosPage();

        WebElement btnCrossOnModal = driver.findElement(By.cssSelector(page.btnCrossOnModalCss));
        btnCrossOnModal.click();

        WebElement btnEnter = driver.findElement(By.xpath(page.btnEnterXpath));
        btnEnter.click();

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
