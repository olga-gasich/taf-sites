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
    private String inputEmailAddressId = "username";
    private String btnContinueWithEmailXpath = "//span[text()='Продолжить через электронную почту']";
    private String inputPswId = "new_password";
    private String inputConfirmPswId = "confirmed_password";
    private String btnSubmitXpath = "//span[text()='Создать аккаунт']";
    private String baseURL = "https://www.booking.com/";

    public BookingPage(ChromeDriver newDriver){
        driver = newDriver;
    }

    public void openBaseURL() {

        driver.get(baseURL);
    }

    public void clickBtnSignInOrRegister(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSignInOrRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnSignInOrRegisterXpath)));
        btnSignInOrRegister.click();
    }

    public void fillInputEmailAddress(String str){

        WebElement inputEmailAddress = driver.findElement(By.id(inputEmailAddressId));
        inputEmailAddress.sendKeys(str);
    }

    public void clickBtnContinueWithEmail(){

        WebElement btnContinueWithEmail = driver.findElement(By.xpath(btnContinueWithEmailXpath));
        btnContinueWithEmail.click();
    }

    public void fillInputPsw(String str){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputPsw = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputPswId)));
        inputPsw.sendKeys(str);
    }

    public void fillInputConfirmPsw(String str){

        WebElement inputConfirmPsw = driver.findElement(By.id(inputConfirmPswId));
        inputConfirmPsw.sendKeys(str);
    }

    public void clickBtnSubmit(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnSubmitXpath)));
        btnSubmit.click();
    }
}
