package by.itacademy.olga.gasich.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoPage {

    private ChromeDriver driver;
    private String inputEmailAddressXpath = "/html/body/div/div[1]/form/p[1]/input";
    private String inputPswXpath = "/html/body/div/div[1]/form/p[2]/input[1]";
    private String btnSearchXpath = "/html/body/div/div[1]/form/p[2]/input[2]";

    public PizzatempoPage(ChromeDriver newDriver){
        driver = newDriver;
    }

    public void clickBtnSearch(){

        WebElement btnSearch = driver.findElement(By.xpath(btnSearchXpath));
        btnSearch.click();
    }

    public void fillInputEmailAddress(String str){

        WebElement inputEmailAddress = driver.findElement(By.xpath(inputEmailAddressXpath));
        inputEmailAddress.sendKeys(str);
    }

    public void fillInputPsw(String str){

        WebElement inputPsw = driver.findElement(By.xpath(inputPswXpath));
        inputPsw.sendKeys(str);
    }
}

