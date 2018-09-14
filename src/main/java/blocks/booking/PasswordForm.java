package blocks.booking;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by bigdrop on 9/14/2018.
 */
@Block(@FindBy(className = "password-form"))
public class PasswordForm extends HtmlElement {

    public TextInput getPasswordField() {
        return passwordField;
    }

    @FindBy(id = "form-create-account-password")
    private TextInput passwordField;

    public TextInput getConfirmPassField() {
        return confirmPassField;
    }

    @FindBy(id = "form-create-account-password-again")
    private TextInput confirmPassField;
}
