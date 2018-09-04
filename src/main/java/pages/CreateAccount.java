package pages;

import data.Users;
import data.UsersData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.account.MyAccount;
import utils.ConfigProperties;

import java.util.List;

/**
 * Created by bigdrop on 8/31/2018.
 */
public class CreateAccount extends BasePage {

    public CreateAccount(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("signUp.url"));
    }

    @FindBy(id = "registration-block-first-name")
    private WebElement firstNameField;

    @FindBy(id = "registration-block-last-name")
    private WebElement lastNameField;

    @FindBy(id = "registration-block-password")
    private WebElement passwordField;

    @FindBy(id = "registration-block-password-confirmation")
    private WebElement confPasswordField;

    @FindBy(id = "registration-block-email")
    private WebElement emailField;

    @FindBy(id = "registration-block-phone")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id='registration-block-location']//ancestor::div[1]")
    private WebElement locationField;

    @FindBy(xpath = "//input[@value='Create an Account']")
    private WebElement createAccBut;

    public MyAccount registrationFromJson (UsersData users) {
        openRegistrationPage();
        fillRegistrationFieldsFromJson(users);
        createAccBut.click();
        return new MyAccount(driver);
    }

    public MyAccount registration (Users users) {
        fillRegistrationFields(users);
        createAccBut.click();
        return new MyAccount(driver);
    }

    public void fillRegistrationFieldsFromJson (UsersData users) {
        type(firstNameField, users.getFirstName());
        type(lastNameField, users.getLastName());
        type(passwordField, users.getPassword());
        type(confPasswordField, users.getConfPassword());
        type(emailField, users.getEmail());
        type(phoneField, users.getPhone());
        fillLocationField(users.getLocation());
    }

    public void fillRegistrationFields(Users users) {
        type(firstNameField, users.getFirstName());
        type(lastNameField, users.getLastName());
        type(passwordField, users.getPassword());
        type(confPasswordField, users.getConfPassword());
        type(emailField, users.getEmail());
        type(phoneField, users.getPhone());
        fillLocationField(users.getLocation());
    }

    public CreateAccount openRegistrationPage() {
        signUpLink.click();
        return new CreateAccount(driver);
    }

    public void fillLocationField(String nameLocation) {
        locationField.click();
        findLocationLink.click();
        chooseLocation(nameLocation);
    }
}
