package pages.booking;

import blocks.booking.AppointmentDate;
import blocks.booking.TherapistPreferences;
import blocks.booking.TherapistSchedule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

/**
 * Created by bigdrop on 9/13/2018.
 */
public class PrefferedDateTime extends BasePage {

    public PrefferedDateTime(WebDriver driver) {
        super(driver);
    }

    TherapistPreferences therapistPreferences;
    AppointmentDate appointmentDate;
    TherapistSchedule therapistSchedule;

    @Override
    public void open() {

    }

    @FindBy(css= "a.continue")
    private Button continueBut;

    public String chooseTherapistAndDateTime(String therapistSpecific, String date, String time) {
        waitUntilElementWillBeClickable(therapistPreferences.getListTherapistPreferences().get(0));
        therapistPreferences.chooseTherapistPreferences(therapistSpecific);
        chooseAppointmentDate(date);
        String therapistName = chooseAppointmentTime(time);
        waitUntilTextInElementAppear(therapistPreferences, "waiting");
        continueBut.click();
        return therapistName;
    }

    public void chooseAppointmentDate(String date) {
        List<HtmlElement> listDate = appointmentDate.getListAppointmentDate();
        for (int i = 0; i < listDate.size() - 30; i++) {
            if(isElementInvisible(listDate.get(i)) == true)
                appointmentDate.clickNextArrow();
            boolean res = isElementContainsAttributeValue(listDate.get(i), "class", "disabled");
            String ter = listDate.get(i).getText();
            if(listDate.get(i).getText().contains(date) && isElementContainsAttributeValue(listDate.get(i), "class", "disabled") == false) {
                listDate.get(i).click();
                return;
            }
        }
        for (int i = listDate.size() - 30; i > 0; i--) {
            if(isElementInvisible(listDate.get(i)) == true)
                appointmentDate.clickPrevArrow();
            if(isElementContainsAttributeValue(listDate.get(i), "class", "disabled") == false) {
                listDate.get(i).click();
                return;
            }
        }
        listDate.get(1).click();
    }

    public String chooseAppointmentTime(String time) {
        List<HtmlElement> listTime = therapistSchedule.getListTimeTherapist();
        for (int i = 0; i < listTime.size(); i++) {
            if(listTime.get(i).getText().contains(time) && isElementContainsAttributeValue(listTime.get(i), "class", "disabled") == false) {
                listTime.get(i).click();
                return therapistSchedule.getTherapistNameActive().getText();
            }
        }
        for (int i = 0; i < listTime.size(); i++) {
            if(isElementContainsAttributeValue(listTime.get(i), "class", "disabled") == false) {
                listTime.get(i).click();
                return therapistSchedule.getTherapistNameActive().getText();
            }
        }
        return null;
    }
}
