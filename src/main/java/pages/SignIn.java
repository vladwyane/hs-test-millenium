package pages;

import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 8/31/2018.
 */
public class SignIn extends BasePage {

    public SignIn(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("signIn.url"));
    }

    @FindBy(id = "login-authorization-email")
    private WebElement emailField;

    @FindBy(id = "login-authorization-password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains (text(), 'Create an Account')]")
    private WebElement createAccountButton;

    @FindBy(xpath = "//a[contains (text(), 'Forgot your Password')]")
    private WebElement forgotPasswordLink;

    public CreateAccount openCreateAccPageFromSignIn() {
        open();
        createAccountButton.click();
        return new CreateAccount(driver);
    }

    public void logIn(Users users) {
        type(emailField, users.getEmail());
        type(passwordField, users.getPassword());
        loginButton.click();
    }
}
