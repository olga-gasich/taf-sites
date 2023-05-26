package by.itacademy.olga.gasich.taf.sites;

import org.openqa.selenium.chrome.ChromeDriver;

public class BookingStep {

    BookingPage page;
    private ChromeDriver driver;

    public BookingStep(ChromeDriver newDriver){

        driver = newDriver;
        page = new BookingPage(driver);
    }

    public void fillEmailFormAndSubmit(String name){

        page.clickBtnSignInOrRegister();
        page.fillInputEmailAddress(name);
        page.clickBtnContinueWithEmail();
    }

    public void fillLoginFormAndSubmit(String name, String password){

        page.clickBtnSignInOrRegister();
        page.fillInputEmailAddress(name);
        page.clickBtnContinueWithEmail();
        page.fillInputPsw(password);
        page.fillInputConfirmPsw(password);
        page.clickBtnSubmit();
    }
}
