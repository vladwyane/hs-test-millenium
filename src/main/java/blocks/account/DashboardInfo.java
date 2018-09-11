package blocks.account;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by bigdrop on 9/10/2018.
 */
@Block(@FindBy(className = "dashboard-info"))
public class DashboardInfo extends HtmlElement {

    public Link getUserEmail() {
        return userEmail;
    }

    @FindBy(xpath = "//div[@class='info']//a[contains(@href, 'mailto')]")
    private Link userEmail;

    public Link getChangePassLink() {
        return changePassLink;
    }

    @FindBy(xpath = "//div[@class='info']//a[contains(text(), 'Change Password')]")
    private Link changePassLink;

    public Link getPhoneUser() {
        return phoneUser;
    }

    @FindBy(xpath = "//div[@class='info']//a[contains(@href, 'tel')]")
    private Link phoneUser;

    public Button getEditButt() {
        return editButt;
    }

    @FindBy(xpath = "//a[contains(text(), 'Edit')]")
    private Button editButt;

    public HtmlElement getUserStatus() {
        return userStatus;
    }

    @FindBy(xpath = "//h2[contains(text(), 'Membership Status')]/following-sibling::div//p")
    private HtmlElement userStatus;
}
