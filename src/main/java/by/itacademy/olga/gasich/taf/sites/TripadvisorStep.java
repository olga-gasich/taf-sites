package by.itacademy.olga.gasich.taf.sites;

import org.openqa.selenium.chrome.ChromeDriver;

public class TripadvisorStep {

    TripadvisorPage page;
    private ChromeDriver driver;

    public TripadvisorStep(ChromeDriver newDriver){

        driver = newDriver;
        page = new TripadvisorPage(driver);
    }

    public void fillLoginFormAndSubmit(String name, String password){

        page.clickBtnSignIn();
        page.clickBtnContinueWithEmail();
        page.fillInputEmailAddress(name);
        page.fillInputPsw(password);
        page.clickBtnSubmit();
    }
}
