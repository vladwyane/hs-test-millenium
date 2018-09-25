package blocks.popUps;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by bigdrop on 9/25/2018.
 */
@Block(@FindBy(className = "new-password"))
public class ResetPasswordPopup extends HtmlElement {

    public TextInput getNewPasswordField() {
        return newPasswordField;
    }

    @FindBy(id = "popup-new-password-password")
    private TextInput newPasswordField;

    public TextInput getNewPasswordRepeatField() {
        return newPasswordRepeatField;
    }

    @FindBy(id = "popup-new-password-repeat-password")
    private TextInput newPasswordRepeatField;

    @FindBy(xpath = "//input[@value='Reset Password']")
    private Button resetPassButton;

    public void clickResetPassBut() {
        resetPassButton.click();
    }
}
