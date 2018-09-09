package blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Block(@FindBy(css = ".login-block form"))
public class SignInForm extends HtmlElement {

    public TextInput getEmailField() {
        return emailField;
    }

    @FindBy(id = "login-authorization-email")
    private TextInput emailField;

    public TextInput getPasswordField() {
        return passwordField;
    }

    @FindBy(id = "login-authorization-password")
    private TextInput passwordField;

    @FindBy(xpath = "//input[@value='login']")
    private Button loginButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    @FindBy(xpath = "//a[contains (text(), 'Create an Account')]")
    private Button createAccountButton;

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    @FindBy(xpath = "//a[contains (text(), 'Forgot your Password')]")
    private Link forgotPasswordLink;

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

}
