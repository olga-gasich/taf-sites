package by.itacademy.olga.gasich.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoPage {

    private ChromeDriver driver;
    private String inputEmailAddressName = "astroauth_login";
    private String inputPswName = "astroauth_pass";
    private String btnSearchName = "astroauth_submit";
    private String baseURL = "https://www.pizzatempo.by/";

    public PizzatempoPage(ChromeDriver newDriver){
        driver = newDriver;
    }

    public void openBaseURL() {

        driver.get(baseURL);
    }

    public void clickBtnSearch(){

        WebElement btnSearch = driver.findElement(By.name(btnSearchName));
        btnSearch.click();
    }

    public void fillInputEmailAddress(String str){

        WebElement inputEmailAddress = driver.findElement(By.name(inputEmailAddressName));
        inputEmailAddress.sendKeys(str);
    }

    public void fillInputPsw(String str){

        WebElement inputPsw = driver.findElement(By.name(inputPswName));
        inputPsw.sendKeys(str);
    }
}
