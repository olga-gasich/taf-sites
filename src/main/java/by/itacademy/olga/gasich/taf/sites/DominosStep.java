package by.itacademy.olga.gasich.taf.sites;

import org.openqa.selenium.chrome.ChromeDriver;

public class DominosStep {

    DominosPage page;
    private ChromeDriver driver;

    public DominosStep(ChromeDriver newDriver){

        driver = newDriver;
        page = new DominosPage(driver);
    }

    public void fillLoginFormAndSubmit(String name, String password){

        page.clickBtnCrossOnModal();
        page.clickBtnEnter();
        page.fillInputEmailAddress(name);
        page.fillInputPsw(password);
        page.clickBtnSubmit();
    }
}
