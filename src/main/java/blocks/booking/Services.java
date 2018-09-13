package blocks.booking;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

/**
 * Created by bigdrop on 9/12/2018.
 */
@Block(@FindBy(className = "services"))
public class Services extends HtmlElement {

    @Name("ArrayList of title services")
    @FindBys( {@FindBy(css = ".service-content li h4")} )
    public List<HtmlElement> listTitleServ;

    @Name("ArrayList of button book nov")
    @FindBys( {@FindBy(xpath = "//div[contains(@class, 'service-content')]//a[contains(@class, 'btn-')]")} )
    public List<HtmlElement> listButBookNow;

    public void chooseService(String serviceName) {
        for (int i = 0; i < listTitleServ.size(); i++) {
            if (serviceName.equals(listTitleServ.get(i).getText())) {
                listButBookNow.get(i).click();
                return;
            }
        }
        listButBookNow.get(listButBookNow.size() - 1).click();
    }
}
