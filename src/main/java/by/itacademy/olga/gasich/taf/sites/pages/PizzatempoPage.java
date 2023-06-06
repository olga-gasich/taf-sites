package by.itacademy.olga.gasich.taf.sites.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoPage {

    private ChromeDriver driver;
    private String inputEmailAddressName = "astroauth_login";
    private String inputPswName = "astroauth_pass";
    private String btnSearchName = "astroauth_submit";
    private String errorXpath = "//*[@id='alert']/div[2]/div[2]";
    private String baseURL = "https://www.pizzatempo.by/";

    public PizzatempoPage(ChromeDriver newDriver){
        driver = newDriver;
    }

    public void openBaseURL() {

        driver.get(baseURL);
    }

    public PizzatempoPage clickBtnSearch(){

        WebElement btnSearch = driver.findElement(By.name(btnSearchName));
        btnSearch.click();
        return this;
    }

    public PizzatempoPage fillInputEmailAddress(String str){

        WebElement inputEmailAddress = driver.findElement(By.name(inputEmailAddressName));
        inputEmailAddress.sendKeys(str);
        return this;
    }

    public PizzatempoPage fillInputPsw(String str){

        WebElement inputPsw = driver.findElement(By.name(inputPswName));
        inputPsw.sendKeys(str);
        return this;
    }

    public String getAlert() {

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        return alertMessage;
    }

    public String getError(){

        WebElement actError = driver.findElement(By.xpath(errorXpath));
        String actErrorMessage = actError.getText();
        return actErrorMessage;
    }
}
