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
@Block(@FindBy(className = "appointment-date"))
public class AppointmentDate extends HtmlElement {

    public List<HtmlElement> getListAppointmentDate() {
        return listAppointmentDate;
    }

    @Name("ArrayList of appointment date")
    @FindBys( {@FindBy(css = ".date-list li button")} )
    public List<HtmlElement> listAppointmentDate;

    public Button getNextArrowOfCarousel() {
        return nextArrowOfCarousel;
    }

    @FindBy(css = "button.next")
    protected Button nextArrowOfCarousel;

    public void clickNextArrow() {
        nextArrowOfCarousel.click();
    }

    public Button getPrevArrowOfCarousel() {
        return prevArrowOfCarousel;
    }

    @FindBy(css = "button.prev")
    protected Button prevArrowOfCarousel;

    public void clickPrevArrow() {
        prevArrowOfCarousel.click();
    }
}
