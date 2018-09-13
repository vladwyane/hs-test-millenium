package blocks.booking;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

/**
 * Created by bigdrop on 9/13/2018.
 */

@Block(@FindBy(xpath = "(//section[@class='appointment-date ember-view']/following-sibling::div)[1]"))
public class TherapistSchedule extends HtmlElement {

    public List<HtmlElement> getListTimeTherapist() {
        return listTimeTherapist;
    }

    @Name("ArrayList of time available therapist")
    @FindBys( {@FindBy(xpath = "//div[@class='time-slider']//li//button")} )
    public List<HtmlElement> listTimeTherapist;

    public HtmlElement getTherapistNameActive() {
        return therapistNameActive;
    }

    @Name("Therapist's name which chosen in schedule")
    @FindBy(xpath = "//div[@class='time-slider']//button[@aria-pressed='true']//ancestor::div[@class='time-slider']/h3")
    private HtmlElement therapistNameActive;
}
