package by.itacademy.olga.gasich.taf.sites.steps;

import by.itacademy.olga.gasich.taf.sites.pages.BookingPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookingStep {

    BookingPage page;
    private ChromeDriver driver;

    public BookingStep(ChromeDriver newDriver){

        driver = newDriver;
        page = new BookingPage(driver);
    }

    public void dontFillEmailFormAndSubmit(String name){

        page.clickBtnSignInOrRegister();
        page.fillInputEmailAddress(name);
        page.clickBtnContinueWithEmail();
        page.getEmptyEmailAddressError();
    }

    public void fillEmailFormAndSubmit(String name){

        page.clickBtnSignInOrRegister();
        page.fillInputEmailAddress(name);
        page.clickBtnContinueWithEmail();
        page.getInvalidEmailAddressError();
    }

    public void fillLoginFormWithEmptyPasswordsAndSubmit(String name, String password){

        page.clickBtnSignInOrRegister();
        page.fillInputEmailAddress(name);
        page.clickBtnContinueWithEmail();
        page.fillInputPsw(password);
        page.fillInputConfirmPsw(password);
        page.clickBtnSubmit();
        page.getEmptyPswError();
        page.getEmptyConfirmPswError();
    }

    public void fillLoginFormWithInvalidNewPasswordAndSubmit(String name, String password){

        page.clickBtnSignInOrRegister();
        page.fillInputEmailAddress(name);
        page.clickBtnContinueWithEmail();
        page.fillInputPsw(password);
        page.fillInputConfirmPsw(password);
        page.clickBtnSubmit();
        page.getInvalidPswError();
    }
}
