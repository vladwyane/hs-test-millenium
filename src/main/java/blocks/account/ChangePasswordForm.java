package blocks.account;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by bigdrop on 9/11/2018.
 */
@Block(@FindBy(xpath = "//h3[contains(text(), 'Password')]//following-sibling::form"))
public class ChangePasswordForm extends HtmlElement {

    public TextInput getCurrentPassField() {
        return currentPassField;
    }

    @FindBy(id = "password-form-password")
    private TextInput currentPassField;

    public TextInput getNewPassField() {
        return newPassField;
    }

    @FindBy(id = "password-form-new-password")
    private TextInput newPassField;

    public TextInput getConfirmPassField() {
        return confirmPassField;
    }

    @FindBy(id = "password-form-confirm-password")
    private TextInput confirmPassField;

    public Button getChangePassBut() {
        return changePassBut;
    }

    @FindBy(xpath = "//input[@value='Change Password']")
    private Button changePassBut;
}
