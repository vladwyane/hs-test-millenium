package blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;

@Block(@FindBy(className = "registration-block-form"))
public class CreateAccountForm extends HtmlElement{

    public TextInput getFirstNameField() {
        return firstNameField;
    }

    @FindBy(id = "registration-block-first-name")
    private TextInput firstNameField;

    public HtmlElement getFirstNameFieldNote() {
        return firstNameFieldNote;
    }

    @Name("Error note of first name field")
    @FindBy(xpath = "//input[@id='registration-block-first-name']/following-sibling::div[@class='note']")
    private HtmlElement firstNameFieldNote;

    public TextInput getLastNameField() {
        return lastNameField;
    }

    @FindBy(id = "registration-block-last-name")
    private TextInput lastNameField;

    public HtmlElement getLastNameFieldNote() {
        return lastNameFieldNote;
    }

    @Name("Error note of last name field")
    @FindBy(xpath = "//input[@id='registration-block-last-name']/following-sibling::div[@class='note']")
    private HtmlElement lastNameFieldNote;

    public TextInput getPasswordField() {
        return passwordField;
    }

    @FindBy(id = "registration-block-password")
    private TextInput passwordField;

    public HtmlElement getPasswordFieldNote() {
        return passwordFieldNote;
    }

    @Name("Error note of password field")
    @FindBy(xpath = "//input[@id='registration-block-password']/following-sibling::div[@class='note']")
    private HtmlElement passwordFieldNote;

    public TextInput getConfPasswordField() {
        return confPasswordField;
    }

    @FindBy(id = "registration-block-password-confirmation")
    private TextInput confPasswordField;

    public HtmlElement getConfPasswordFieldNote() {
        return confPasswordFieldNote;
    }

    @Name("Error note of confirm password field")
    @FindBy(xpath = "//input[@id='registration-block-password-confirmation']/following-sibling::div[@class='note']")
    private HtmlElement confPasswordFieldNote;

    public TextInput getEmailField() {
        return emailField;
    }

    @FindBy(id = "registration-block-email")
    private TextInput emailField;

    public HtmlElement getEmailFieldNote() {
        return emailFieldNote;
    }

    @Name("Error note of email field")
    @FindBy(xpath = "//input[@id='registration-block-email']/following-sibling::div[@class='note']")
    private HtmlElement emailFieldNote;

    public TextInput getPhoneField() {
        return phoneField;
    }

    @FindBy(id = "registration-block-phone")
    private TextInput phoneField;

    public WebElement getPhoneFieldNote() {
        return phoneFieldNote;
    }

    @Name("Error note of phone field")
    @FindBy(xpath = "//input[@id='registration-block-phone']/following-sibling::div[@class='note']")
    private WebElement phoneFieldNote;

    public Link getLocationField() {
        return locationField;
    }

    @Name("Field for location popup")
    @FindBy(xpath = "//input[@id='registration-block-location']//ancestor::div[1]")
    private Link locationField;

    @Name("Create account button")
    @FindBy(xpath = "//input[@value='Create an Account']")
    private Button createAccBut;

    public void clickCreateAccBut() {
        createAccBut.click();
    }
}
