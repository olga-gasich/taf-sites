package by.itacademy.olga.gasich.taf.sites.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DominosPage {

    private ChromeDriver driver;
    private String btnCrossOnModalCss = "body > div.custom-modal.custom-modal--size-content.custom-modal--padding-none.custom-modal--bg-transparent > div.custom-modal__content-holder > button > span > span.custom-button__content-children > svg";
    private String btnEnterXpath = "//span[text()='Войти']";
    private String inputEmailAddressName = "email";
    private String inputPswName = "password";
    private String btnSubmitXpath = "/html/body/div[4]/div[2]/div/div/div/div[2]/div[2]/div/form/div/button";
    private String errorXpath = "//div[@class='notification__content']]";
    private String baseURL = "https://dominos.by/";

    public void openBaseURL() {

        driver.get(baseURL);
    }

    public DominosPage(ChromeDriver newDriver){
        driver = newDriver;
    }

    public void clickBtnCrossOnModal(){

        WebElement btnCrossOnModal = driver.findElement(By.cssSelector(btnCrossOnModalCss));
        btnCrossOnModal.click();
    }

    public void clickBtnEnter(){

        WebElement btnEnter = driver.findElement(By.xpath(btnEnterXpath));
        btnEnter.click();
    }

    public void fillInputEmailAddress(String str){

        WebElement inputEmailAddress = driver.findElement(By.name(inputEmailAddressName));
        inputEmailAddress.sendKeys(str);
    }

    public void fillInputPsw(String str){

        WebElement inputPsw = driver.findElement(By.name(inputPswName));
        inputPsw.sendKeys(str);
    }

    public void clickBtnSubmit(){

        WebElement btnSubmit = driver.findElement(By.xpath(btnSubmitXpath));
        btnSubmit.click();
    }

    public void getError(){

        WebElement actError = driver.findElement(By.xpath(errorXpath));
        String actErrorMessage = actError.getText();
        String expErrorMessage = "Неверный логин или пароль";
        Assertions.assertEquals(expErrorMessage, actErrorMessage);
    }
}
