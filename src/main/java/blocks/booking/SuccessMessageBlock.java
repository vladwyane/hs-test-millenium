package blocks.booking;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
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

}
