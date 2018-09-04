package pages.popUps;

import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 9/4/2018.
 */
public class SignInPopup extends BasePage {

    public SignInPopup(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("home.url"));
        signInLink.click();
    }

    @FindBy(id = "sign-in-popup-email")
    private WebElement emailField;

    @FindBy(id = "sign-in-popup-password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[contains (text(), 'Forgot your Password')]")
    private WebElement forgotPasswordLink;

    public void logIn(Users users) {
        type(emailField, users.getEmail());
        type(passwordField, users.getPassword());
        signInButton.click();
    }
}
