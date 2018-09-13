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
@Block(@FindBy(className = "duration"))
public class Duration extends HtmlElement{

    public List<HtmlElement> getListTimeDuration() {
        return listTimeDuration;
    }

    @Name("ArrayList of time duration")
    @FindBys( {@FindBy(css = ".duration-list .time")} )
    public List<HtmlElement> listTimeDuration;

    public void chooseTimeDuration(String time) {
        for (int i = 0; i < listTimeDuration.size(); i++) {
            if (time.equals(listTimeDuration.get(i).getText())) {
                listTimeDuration.get(i).click();
                return;
            }
        }
        listTimeDuration.get(listTimeDuration.size() - 1).click();
    }
}
