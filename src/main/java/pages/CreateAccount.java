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

    @FindBy(xpath = "//input[@id='registration-block-first-name']/following-sibling::div[@class='note']")
    private WebElement firstNameFieldNote;

    @FindBy(id = "registration-block-last-name")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='registration-block-last-name']/following-sibling::div[@class='note']")
    private WebElement lastNameFieldNote;

    @FindBy(id = "registration-block-password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='registration-block-password']/following-sibling::div[@class='note']")
    private WebElement passwordFieldNote;

    @FindBy(id = "registration-block-password-confirmation")
    private WebElement confPasswordField;

    @FindBy(xpath = "//input[@id='registration-block-password-confirmation']/following-sibling::div[@class='note']")
    private WebElement confPasswordFieldNote;

    @FindBy(id = "registration-block-email")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='registration-block-email']/following-sibling::div[@class='note']")
    private WebElement emailFieldNote;

    @FindBy(id = "registration-block-phone")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id='registration-block-phone']/following-sibling::div[@class='note']")
    private WebElement phoneFieldNote;

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

    public CreateAccount checkingErrorNotesAllFieldsAreBlank() {
        String errorNoteFieldsBlank = "This field can't be blank";
        String errorColor = "rgba(235, 0, 0, 1)";
        String errorBorderColor = "rgb(235, 0, 0)";
        createAccBut.click();
        softAssert.assertEquals(firstNameFieldNote.getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(firstNameFieldNote.getCssValue("color"), errorColor);
        softAssert.assertEquals(firstNameField.getCssValue("border-color"), errorBorderColor);

        softAssert.assertEquals(lastNameFieldNote.getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(lastNameFieldNote.getCssValue("color"), errorColor);
        softAssert.assertEquals(lastNameField.getCssValue("border-color"), errorBorderColor);

        softAssert.assertEquals(passwordFieldNote.getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(passwordFieldNote.getCssValue("color"), errorColor);
        softAssert.assertEquals(passwordField.getCssValue("border-color"), errorBorderColor);

        softAssert.assertEquals(emailFieldNote.getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(emailFieldNote.getCssValue("color"), errorColor);
        softAssert.assertEquals(emailField.getCssValue("border-color"), errorBorderColor);

        softAssert.assertEquals(phoneFieldNote.getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(phoneFieldNote.getCssValue("color"), errorColor);
        softAssert.assertEquals(phoneField.getCssValue("border-color"), errorBorderColor);

        softAssert.assertAll();
        return this;
    }

    public CreateAccount checkingErrorNoteNotMatchPassword() {
        String errorNoteNotMatchPassword = "This field doesn't match password";
        String errorColor = "rgba(235, 0, 0, 1)";
        String errorBorderColor = "rgb(235, 0, 0)";
        softAssert.assertEquals(confPasswordFieldNote.getText(), errorNoteNotMatchPassword);
        softAssert.assertEquals(confPasswordFieldNote.getCssValue("color"), errorColor);
        softAssert.assertEquals(confPasswordField.getCssValue("border-color"), errorBorderColor);
        softAssert.assertAll();
        return this;
    }

    public CreateAccount checkingErrorNoteExistEmail(Users users) {
        String errorNotExistEmail = "Email \"" + users.getEmail() + "\" has already been taken.";
        String errorColor = "rgba(235, 0, 0, 1)";
        String errorBorderColor = "rgb(235, 0, 0)";
        softAssert.assertEquals(emailFieldNote.getText(), errorNotExistEmail);
        softAssert.assertEquals(emailFieldNote.getCssValue("color"), errorColor);
        softAssert.assertEquals(emailField.getCssValue("border-color"), errorBorderColor);
        softAssert.assertAll();
        return this;
    }
}
