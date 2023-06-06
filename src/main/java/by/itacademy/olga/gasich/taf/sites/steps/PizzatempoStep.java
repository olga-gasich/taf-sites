package by.itacademy.olga.gasich.taf.sites.steps;

import by.itacademy.olga.gasich.taf.sites.pages.PizzatempoPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoStep {

    PizzatempoPage page;
    private ChromeDriver driver;

    public PizzatempoStep(ChromeDriver newDriver){

        driver = newDriver;
        page = new PizzatempoPage(driver);
    }

    public void fillLoginFormAndSubmit(String name, String password){

        page.fillInputEmailAddress(name);
        page.fillInputPsw(password);
        page.clickBtnSearch();
    }
}
