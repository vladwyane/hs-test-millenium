package blocks.popUps;

import blocks.BaseBlock;
import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 9/4/2018.
 */
@Block(@FindBy(className = "sign-in-popups"))
public class SignInPopup extends HtmlElement {

    public TextInput getEmailField() {
        return emailField;
    }

    @FindBy(id = "sign-in-popup-email")
    private TextInput emailField;


    public TextInput getPasswordField() {
        return passwordField;
    }

    @FindBy(id = "sign-in-popup-password")
    private TextInput passwordField;

    @FindBy(xpath = "//input[@value='Sign in']")
    private Button signInButton;

    public void clickSignInButton() {
        signInButton.click();
    }

    public Link getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    @FindBy(xpath = "//a[contains (text(), 'Forgot your Password')]")
    private Link forgotPasswordLink;

}
