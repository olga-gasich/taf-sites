package by.itacademy.olga.gasich.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PizzatempoTest {

    ChromeDriver driver;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.pizzatempo.by/");
    }

    @Test
    public void testFillFormWithEmptyEmailAndEmptyPassword() {

        PizzatempoPage page = new PizzatempoPage();

        WebElement btnSearch = driver.findElement(By.xpath(page.btnSearchXpath));
        btnSearch.click();
    }

    @Test
    public void testFillFormWithInvalidEmail() {

        PizzatempoPage page = new PizzatempoPage();

        WebElement inputEmailAddress = driver.findElement(By.xpath(page.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("olagasich@gmail.com.");

        WebElement btnSearch = driver.findElement(By.xpath(page.btnSearchXpath));
        btnSearch.click();
    }

    @Test
    public void testFillFormWithEmptyEmailAndSomePassword() {

        PizzatempoPage page = new PizzatempoPage();

        WebElement inputPsw = driver.findElement(By.xpath(page.inputPswXpath));
        inputPsw.sendKeys("123456");

        WebElement btnSearch = driver.findElement(By.xpath(page.btnSearchXpath));
        btnSearch.click();
    }

    @Test
    public void testFillFormWithValidEmailAndEmptyPassword() {

        PizzatempoPage page = new PizzatempoPage();

        WebElement inputEmailAddress = driver.findElement(By.xpath(page.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("olagasich@gmail.com");

        WebElement btnSearch = driver.findElement(By.xpath(page.btnSearchXpath));
        btnSearch.click();
    }

    @Test
    public void testFillFormWithValidEmailAndSomePassword() {

        PizzatempoPage page = new PizzatempoPage();

        WebElement inputEmailAddress = driver.findElement(By.xpath(page.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("olagasich@gmail.com");

        WebElement inputPsw = driver.findElement(By.xpath(page.inputPswXpath));
        inputPsw.sendKeys("123456");

        WebElement btnSearch = driver.findElement(By.xpath(page.btnSearchXpath));
        btnSearch.click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
