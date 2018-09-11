package blocks.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

/**
 * Created by bigdrop on 9/11/2018.
 */
@Block(@FindBy(xpath = "//h3[contains(text(), 'Information')]//following-sibling::form"))
public class AccountContactInfoForm extends HtmlElement {

    public TextInput getUserFirstName() {
        return userFirstName;
    }

    @FindBy(id = "contact-information-first-name")
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

    public TextInput getUserAddress() {
        return userAddress;
    }

    @FindBy(id = "contact-information-address")
    private TextInput userAddress;

    public TextInput getUserCity() {
        return userCity;
    }

    @FindBy(id = "contact-information-city")
    private TextInput userCity;

    public TextInput getUserZipCode() {
        return userZipCode;
    }

    @FindBy(id = "contact-information-zip")
    private TextInput userZipCode;

    public HtmlElement getStateSelect() {
        return stateSelect;
    }

    @FindBy(xpath = "//select[@id='contact-information-state']//following-sibling::span")
    private HtmlElement stateSelect;

    public List<HtmlElement> getListState() {
        return listState;
    }

    @FindBys( {@FindBy(css = ".jcf-select-drop li")} )
    public List<HtmlElement> listState;

    public Button getSaveChangesBut() {
        return saveChangesBut;
    }

    @FindBy(xpath = "//input[@value='Save Changes']")
    private Button saveChangesBut;


}
