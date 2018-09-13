package blocks.booking;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

/**
 * Created by bigdrop on 9/13/2018.
 */
@Block(@FindBy(className = "add-services"))
public class AddAromaServices extends HtmlElement {

    @Name("ArrayList of additional services")
    @FindBys( {@FindBy(css = ".add-services-list li")} )
    public List<HtmlElement> listAddServices;

    public void chooseAddAromaService() {
        listAddServices.get(0).click();
    }
}
