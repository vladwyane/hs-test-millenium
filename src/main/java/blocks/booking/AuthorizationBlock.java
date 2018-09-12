package blocks.booking;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by bigdrop on 9/12/2018.
 */
@Block(@FindBy(className = "authorization-block"))
public class AuthorizationBlock extends HtmlElement {

    public Button getFirstVisitorBut() {
        return firstVisitorBut;
    }

    @FindBy(xpath= "//a[contains(text(), 'first time')]")
    private Button firstVisitorBut;

    public Button getContinueAsGuestBut() {
        return continueAsGuestBut;
    }

    @FindBy(xpath= "//a[contains(text(), 'Continue as Guest')]")
    private Button continueAsGuestBut;

    public TextInput getEmailField() {
        return emailField;
    }

    @FindBy(id= "authorization-email")
    private TextInput emailField;

    public TextInput getPasswordField() {
        return passwordField;
    }

    @FindBy(id= "authorization-password")
    private TextInput passwordField;

    public Link getForgorPassLink() {
        return forgorPassLink;
    }

    @FindBy(xpath= "//a[contains(text(), 'Forgot your Password?')]")
    private Link forgorPassLink;

    public Button getLoginBut() {
        return loginBut;
    }

    @FindBy(xpath= "//input[@value='login']")
    private Button loginBut;
}
