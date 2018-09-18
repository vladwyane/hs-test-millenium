package blocks.booking;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by bigdrop on 9/14/2018.
 */
@Block(@FindBy(className = "success-message"))
public class SuccessMessageBlock extends HtmlElement {

    public HtmlElement getSuccessHeading() {
        return successHeading;
    }

    @FindBy(css = "header h1")
    private HtmlElement successHeading;

    public HtmlElement getBarCode() {
        return barCode;
    }

    @FindBy(id = "barcode")
    private HtmlElement barCode;

    public HtmlElement getAddToCalendarBut() {
        return addToCalendarBut;
    }

    @FindBy(id = "addtocalendar-link")
    private HtmlElement addToCalendarBut;

    public HtmlElement getBookAnotherAppBut() {
        return bookAnotherAppBut;
    }

    @FindBy(xpath = "//a[contains(text(), 'Book Another Appointment')]")
    private HtmlElement bookAnotherAppBut;

    public HtmlElement getDownloadFormBut() {
        return downloadFormBut;
    }

    @FindBy(css = "a.download-link")
    private HtmlElement downloadFormBut;


}
