package by.itacademy.olga.gasich.taf.sites.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TripadvisorPage {

    private ChromeDriver driver;
    private String btnSignInXpath = "//span[@class='biGQs _P ttuOS' and contains(text(),'Sign in')]";
    private String iframeCsspath = "iframe[title='regcontroller']";
    private String btnContinueWithEmailXpath = "//span[contains(text(),'Continue with email')]";
    private String inputEmailAddressXpath = "//*[@id='regSignIn.email']";
    private String inputPswXpath = "//*[@id='regSignIn.password']";
    private String btnSubmitXpath = "//*[@id='regSignIn']/div[4]/button[1]";
    private String errorEmptyEmailXpath = "//div[@class ='body_text' and contains(text(),'E-mail address is required')]";
    private String errorInvalidEmailXpath = "/html/body/span/div[2]";
    private String errorPswXpath = "//div[@class ='body_text' and contains(text(),'Your password must be at least 10 characters. Please try again.')]";
    private String errorIncorrectEmailOrPswXpath = "//*[@id='regErrors']";
    private String baseURL = "https://www.tripadvisor.com/";

    public TripadvisorPage(ChromeDriver newDriver){
        driver = newDriver;
    }

    public void openBaseURL() {

        driver.get(baseURL);
    }

    public void clickBtnSignIn(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSignIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnSignInXpath)));
        btnSignIn.click();
    }

    public void clickBtnContinueWithEmail(){

        driver.switchTo().frame(driver.findElement(By.cssSelector(iframeCsspath)));
        WebElement btnContinueWithEmail = driver.findElement(By.xpath(btnContinueWithEmailXpath));
        btnContinueWithEmail.click();
    }

    public void fillInputEmailAddress(String str){

        WebElement inputEmailAddress = driver.findElement(By.xpath(inputEmailAddressXpath));
        inputEmailAddress.sendKeys(str);
    }

    public void fillInputPsw(String str){

        WebElement inputPsw = driver.findElement(By.xpath(inputPswXpath));
        inputPsw.sendKeys(str);
    }

    public void clickBtnSubmit(){

        WebElement btnSubmit = driver.findElement(By.xpath(btnSubmitXpath));
        btnSubmit.click();
    }

    public String getEmptyEmailError(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorEmptyEmailXpath)));
        String actErrorMessage = actError.getText();
        return actErrorMessage;
    }

    public String getInvalidEmailError(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorInvalidEmailXpath)));
        String actErrorMessage = actError.getText();
        return actErrorMessage;
    }

    public String getEmptyPswError(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorPswXpath)));
        String actErrorMessage = actError.getText();
        return actErrorMessage;
    }

    public String getInvalidEmailOrPswError(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorIncorrectEmailOrPswXpath)));
        String actErrorMessage = actError.getText();
        return actErrorMessage;
    }
}
