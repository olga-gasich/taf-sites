package by.itacademy.olga.gasich.taf.sites.steps;

import by.itacademy.olga.gasich.taf.sites.pages.DominosPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class DominosStep {

    DominosPage page;
    private ChromeDriver driver;

    public DominosStep(ChromeDriver newDriver){

        driver = newDriver;
        page = new DominosPage(driver);
    }

    public void fillLoginFormAndSubmitWithIncorrectData(String name, String password){

        page.clickBtnCrossOnModal();
        page.clickBtnEnter();
        page.fillInputEmailAddress(name);
        page.fillInputPsw(password);
        page.clickBtnSubmit();
    }

    public void fillLoginFormAndSubmitWithCorrectData(String name, String password){

        page.clickBtnCrossOnModal();
        page.clickBtnEnter();
        page.fillInputEmailAddress(name);
        page.fillInputPsw(password);
        page.clickBtnSubmit();
        page.getError();
    }
}
