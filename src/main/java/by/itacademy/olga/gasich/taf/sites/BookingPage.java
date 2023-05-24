package by.itacademy.olga.gasich.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BookingPage {

    private ChromeDriver driver;
    private String btnSignInOrRegisterXpath = "//*[@id='b2indexPage']/div[21]/div/div/div/div[2]/div/a/span";
    private String inputEmailAddressXpath = "//*[@id='username']";
    private String btnContinueWithEmailXpath = "//*[@id='root']/div/div/div/div[2]/div[1]/div/div/div/div/div/div/form/div[3]/button";
    private String inputPswXpath = "//*[@id='password']";
    private String btnSubmitXpath = "//*[@id='root']/div/div/div/div[2]/div[1]/div/div/div/div/div/div/form/div[2]/button";

    public BookingPage(ChromeDriver newDriver){
        driver = newDriver;
    }

    public void clickBtnSignInOrRegister(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSignInOrRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnSignInOrRegisterXpath)));
        btnSignInOrRegister.click();
    }

    public void fillInputEmailAddress(String str){

        WebElement inputEmailAddress = driver.findElement(By.xpath(inputEmailAddressXpath));
        inputEmailAddress.sendKeys(str);
    }

    public void clickBtnContinueWithEmail(){

        WebElement btnContinueWithEmail = driver.findElement(By.xpath(btnContinueWithEmailXpath));
        btnContinueWithEmail.click();
    }

    public void fillInputPsw(String str){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputPsw = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputPswXpath)));
        inputPsw.sendKeys(str);
    }

    public void clickBtnSubmit(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnSubmitXpath)));
        btnSubmit.click();
    }
}
