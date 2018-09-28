package blocks.popUps;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by bigdrop on 9/27/2018.
 */
@Block(@FindBy(className = "modal-first-visit"))
public class FirstVisitPopup extends HtmlElement{

    @FindBy(xpath = "//a[contains(text(), 'close')]")
    protected Button closeBut;

    public void clickCloseBut() {
        closeBut.click();
    }

    public HtmlElement getPopupLabel() {
        return popupLabel;
    }

    @FindBy(id = "modal-first-visit-label")
    protected HtmlElement popupLabel;

}
