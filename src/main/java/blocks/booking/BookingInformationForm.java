package blocks.booking;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

/**
 * Created by bigdrop on 9/13/2018.
 */
@Block(@FindBy(className = "booking-information-form"))
public class BookingInformationForm extends HtmlElement {

    public TextInput getUserFirstName() {
        return userFirstName;
    }

    @FindBy(id = "contact-information-fist-name")
    private TextInput userFirstName;

    public TextInput getUserLastName() {
        return userLastName;
    }

    @FindBy(id = "contact-information-last-name")
    private TextInput userLastName;

    public TextInput getUserEmail() {
        return userEmail;
    }

    @FindBy(id = "contact-information-email")
    private TextInput userEmail;

    public TextInput getUserPhone() {
        return userPhone;
    }

    @FindBy(id = "contact-information-phone")
    private TextInput userPhone;

    public HtmlElement getPrivatePolicyCheckBox() {
        return privatePolicyCheckBox;
    }

    @FindBy(xpath = "//label[contains(text(), 'I agree to the')]")
    private HtmlElement privatePolicyCheckBox;


}
