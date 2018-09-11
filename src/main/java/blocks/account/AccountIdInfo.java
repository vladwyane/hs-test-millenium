package blocks.account;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * Created by bigdrop on 9/10/2018.
 */
@Block(@FindBy(css = ".id-info"))
public class AccountIdInfo extends HtmlElement {

    public HtmlElement getUserName() {
        return userName;
    }

    @FindBy(css = ".name-id span")
    private HtmlElement userName;

    public Button getBookingBut() {
        return BookingBut;
    }

    @FindBy(xpath = "//a[contains(@class, 'btn-')]")
    private Button BookingBut;

    public HtmlElement getAccountPoints() {
        return accountPoints;
    }

    @FindBy(css = ".points strong")
    private HtmlElement accountPoints;



}
