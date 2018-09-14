package blocks.booking;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

/**
 * Created by bigdrop on 9/14/2018.
 */
@Block(@FindBy(className = "step-area"))
public class StepArea extends HtmlElement {

    public List<HtmlElement> getListActiveStepBull() {
        return listActiveStepBull;
    }

    @Name("ArrayList of active step bullets")
    @FindBys( {@FindBy(css = ".step-area li.active")} )
    public List<HtmlElement> listActiveStepBull;
}
