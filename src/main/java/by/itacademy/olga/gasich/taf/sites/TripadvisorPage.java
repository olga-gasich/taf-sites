package by.itacademy.olga.gasich.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TripadvisorPage {

    private ChromeDriver driver;
    private String btnSignInXpath = "//*[@id='lithium-root']/header/div/nav/div/div[2]/a[3]/span";
    private String iframeCsspath = "iframe[title='regcontroller']";
    private String btnContinueWithEmailXpath = "//span[contains(text(),'Continue with email')]";
    private String inputEmailAddressXpath = "//*[@id='regSignIn.email']";
    private String inputPswXpath = "//*[@id='regSignIn.password']";
    private String btnSubmitXpath = "//*[@id='regSignIn']/div[4]/button[1]";

    public TripadvisorPage(ChromeDriver newDriver){
        driver = newDriver;
    }

    public void clickBtnSignIn(){

        WebElement btnSignIn = driver.findElement(By.xpath(btnSignInXpath));
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
}
