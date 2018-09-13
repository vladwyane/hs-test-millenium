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

    public void chooseTherapistAndDateTime(String therapistSpecific, String date, String time) {
        waitUntilElementWillBeClickable(therapistPreferences.getListTherapistPreferences().get(0));
        therapistPreferences.chooseTherapistPreferences(therapistSpecific);
        chooseAppointmentDate(date);
        chooseAppointmentTime(time);
        continueBut.click();
    }

    public void chooseAppointmentDate(String date) {
        List<HtmlElement> listDate = appointmentDate.getListAppointmentDate();
        for (int i = 0; i < listDate.size() - 30; i++) {
            if(isElementInvisible(listDate.get(i)) == true)
                appointmentDate.clickNextArrow();
            if(listDate.get(i).getText().equals(date) && waitUntilElementWillBeClickable(listDate.get(i)) == true) {
                listDate.get(i).click();
                return;
            }
        }
        therapistPreferences.chooseTherapistPreferences("Any Male");
        listDate.get(0).click();
    }

    public String chooseAppointmentTime(String time) {
        List<HtmlElement> listTime = therapistSchedule.getListTimeTherapist();
        for (int i = 0; i < listTime.size(); i++) {
            String timeer = listTime.get(i).getText();
            boolean res = listTime.get(i).getAttribute("class").contains("disabled");
            if(listTime.get(i).getText().contains(time) && listTime.get(i).getAttribute("class").contains("disabled") == false) {
                listTime.get(i).click();
                return therapistSchedule.getTherapistNameActive().getText();
            }
        }
        for (int i = 0; i < listTime.size(); i++) {
            if(waitUntilElementWillBeClickable(listTime.get(i)) == true) {
                listTime.get(i).click();
                return therapistSchedule.getTherapistNameActive().getText();
            }
        }
        return null;
    }
}
