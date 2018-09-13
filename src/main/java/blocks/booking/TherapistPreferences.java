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
@Block(@FindBy(className = "therapist-preferences"))
public class TherapistPreferences extends HtmlElement {

    public List<HtmlElement> getListTherapistPreferences() {
        return listTherapistPreferences;
    }

    @Name("ArrayList of therapist preferences")
    @FindBys( {@FindBy(css = ".preferences-list li")} )
    public List<HtmlElement> listTherapistPreferences;

    public void chooseTherapistPreferences(String therapistSpecific) {
        for (int i = 0; i < listTherapistPreferences.size(); i++) {
            if (therapistSpecific.equals(listTherapistPreferences.get(i).getText())) {
                listTherapistPreferences.get(i).click();
                return;
            }
        }
        listTherapistPreferences.get(0).click();
    }
}
