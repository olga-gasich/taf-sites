package by.itacademy.olga.gasich.taf.sites.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BookingPage {

    private ChromeDriver driver;
    private String btnSignInOrRegisterXpath = "//a[@ class='fc63351294 a822bdf511 d4b6b7a9e7 cfb238afa1 c938084447 f4605622ad']";
    private String inputEmailAddressId = "username";
    private String btnContinueWithEmailXpath = "//span[text()='Продолжить через электронную почту']";
    private String inputPswId = "new_password";
    private String inputConfirmPswId = "confirmed_password";
    private String btnSubmitXpath = "//span[text()='Создать аккаунт']";
    private String emptyEmailActMessageXpath = "//*[@id='username-note']";
    private String invalidEmailActMessageXpath = "//*[@id='username-note']";
    private String emptyPswActMessageXpath = "//*[@id='new_password-note']";
    private String emptyConfirmPswActMessageXpath = "//*[@id='confirmed_password-note']";
    private String invalidPswActMessageXpath = "//*[@id='new_password-note']";
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

    public void getEmptyEmailAddressError(){

        WebElement emptyEmailActMessage = driver.findElement(By.xpath(emptyEmailActMessageXpath));
        String actErrorMessage = emptyEmailActMessage.getText();
        String expErrorMessage = "Введите электронный адрес";
        Assertions.assertEquals(expErrorMessage, actErrorMessage);
    }

    public void getInvalidEmailAddressError(){

        WebElement invalidEmailActMessage = driver.findElement(By.xpath(invalidEmailActMessageXpath));
        String actErrorMessage = invalidEmailActMessage.getText();
        String expErrorMessage = "Проверьте правильность ввода.";
        Assertions.assertEquals(expErrorMessage, actErrorMessage);
    }

    public void getEmptyPswError(){

        WebElement emptyPswActMessage = driver.findElement(By.xpath(emptyPswActMessageXpath));
        String actErrorMessage = emptyPswActMessage.getText();
        String expErrorMessage = "Введите новый пароль.";
        Assertions.assertEquals(expErrorMessage, actErrorMessage);
    }

    public void getEmptyConfirmPswError(){

        WebElement emptyConfirmPswActMessage = driver.findElement(By.xpath(emptyConfirmPswActMessageXpath));
        String actErrorMessage = emptyConfirmPswActMessage.getText();
        String expErrorMessage = "Введите пароль еще раз";
        Assertions.assertEquals(expErrorMessage, actErrorMessage);
    }

    public void getInvalidPswError(){

        WebElement invalidPswActMessage = driver.findElement(By.xpath(invalidPswActMessageXpath));
        String actErrorMessage = invalidPswActMessage.getText();
        String expErrorMessage = "Пароль должен содержать как минимум одну заглавную букву";
        Assertions.assertEquals(expErrorMessage, actErrorMessage);
    }
}
