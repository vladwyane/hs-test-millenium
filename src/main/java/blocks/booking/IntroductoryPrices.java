package blocks.booking;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

/**
 * Created by bigdrop on 9/18/2018.
 */
@Block(@FindBy(className = "services-slider"))
public class IntroductoryPrices extends HtmlElement {

    public List<HtmlElement> getListIntroTitles() {
        return listIntroTitles;
    }

    @Name("ArrayList of title introductory services")
    @FindBys( {@FindBy(xpath = "//span[(@class='duration')]//following-sibling::h4")} )
    public List<HtmlElement> listIntroTitles;

    public List<HtmlElement> getListIntroServiceBut() {
        return listIntroServiceBut;
    }

    @Name("ArrayList of button introductory services")
    @FindBys( {@FindBy(xpath = "//a[contains(text(), 'select')]")} )
    public List<HtmlElement> listIntroServiceBut;
}
