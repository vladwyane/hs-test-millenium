package pages;

import blocks.Header;
import blocks.SignInForm;
import blocks.popUps.FirstVisitPopup;
import blocks.popUps.SignInPopup;
import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.account.Dashboard;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 8/31/2018.
 */
public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private SignInForm signInForm;
    private SignInPopup signInPopup;
    private Header header;
    private FirstVisitPopup firstVisitPopup;

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("signIn.url"));
        if (waitUntilElementAppeared(firstVisitPopup) == true)
            firstVisitPopup.clickCloseBut();
    }

    public CreateAccountPage openCreateAccPageFromSignIn() {
        open();
        signInForm.clickCreateAccountButton();
        return new CreateAccountPage(driver);
    }

    public void logIn(Users users) {
        type(signInForm.getEmailField(), users.getEmail());
        type(signInForm.getPasswordField(), users.getNewPassword());
        signInForm.clickLoginButton();
    }

    public void logInFromSignInPopup(Users users) {
        type(signInPopup.getEmailField(), users.getEmail());
        type(signInPopup.getPasswordField(), users.getNewPassword());
        signInPopup.clickSignInButton();
    }

    public void openSignInPopup() {
        header.clickSignInLink();
    }
}
