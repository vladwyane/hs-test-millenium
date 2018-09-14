package blocks.booking;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by bigdrop on 9/14/2018.
 */
@Block(@FindBy(className = "booking-details"))
public class BookingDetail extends HtmlElement {

    public boolean containsDuration(String duration) {
        if(durationText.getText().contains(duration))
            return true;
        else return false;
    }

    @FindBy(css = ".selected-service li span")
    private HtmlElement durationText;

    public boolean containsService(String service) {
        if(serviceText.getText().contains(service))
            return true;
        else return false;
    }

    @FindBy(css = ".selected-service li")
    private HtmlElement serviceText;

    public boolean containsLocation(String location) {
        if(locationText.getText().contains(location))
            return true;
        else return false;
    }

    @FindBy(css = ".location-info h4")
    private HtmlElement locationText;

    public boolean containsTherapist(String therapist) {
        if(therapistText.getText().contains(therapist))
            return true;
        else return false;
    }

    @FindBy(xpath = "//div[@class='service-info']//i[@class='icon-specific_employee']//ancestor::li")
    private HtmlElement therapistText;

    public boolean containsDate(String date) {
        if(dateText.getText().contains(date))
            return true;
        else return false;
    }

    @FindBy(xpath = "//div[@class='service-info']//i[@class='icon-date']//ancestor::li")
    private HtmlElement dateText;
}
