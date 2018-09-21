package pages.millenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * Created by bigdrop on 9/21/2018.
 */
public class ScheduleEditor extends BasePage {

    public ScheduleEditor(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(xpath = "//input[@value='New']")
    private Button newSchedulBut;

    @FindBy(xpath = "//select[contains(@name, 'Location')]")
    private Select selectLocation;

    @FindBy(xpath = "(//input[contains(@name, 'calDate')])[1]")
    private TextInput calDateField;

    @FindBy(xpath = "//select[contains(@name, 'Employees')]")
    private Select selectEmployee;

    @FindBy(xpath = "(//input[contains(@id, 'In_tp')])[1]")
    private TextInput inTimeField;

    @FindBy(xpath = "(//input[contains(@id, 'Out_tp')])[1]")
    private TextInput outTimeField;

    @FindBy(xpath = "//input[@value='Save']")
    private Button saveBut;

    @FindBy(xpath = "//select[contains(@id, 'Actual')]")
    private Select selectScheduleActivity;

    @FindBy(xpath = "//select[contains(@id, 'Schedule')]")
    private Select selectActualActivity;


    public void addTherapistSchedulBySelectValue(String valueLocation, String date, String valueEmployee, String inTime, String outTime) {
        newSchedulBut.click();
        selectLocation.selectByValue(valueLocation);
        type(calDateField, date);
        selectEmployee.selectByValue(valueEmployee);
        type(inTimeField, inTime);
        type(outTimeField, outTime);
        selectScheduleActivity.selectByVisibleText("Work Time");
        selectActualActivity.selectByVisibleText("Work Time");
        saveBut.click();
    }

    public void addScheduleForDwyane(String date, String inTime, String outTime) {
        newSchedulBut.click();
        selectLocation.selectByValue("2");
        type(calDateField, date);
        selectEmployee.selectByValue("218");
        type(inTimeField, inTime);
        type(outTimeField, outTime);
        selectScheduleActivity.selectByVisibleText("Work Time");
        selectActualActivity.selectByVisibleText("Work Time");
        saveBut.click();
    }

    public void addScheduleForDwyaneOnWeek(String startDate, String inTime, String outTime) throws ParseException {
        for (int i = 0; i < 7; i++) {
            newSchedulBut.click();
            selectLocation.selectByValue("2");
            SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(startDate));
            c.add(Calendar.DATE, i);  // number of days to add
            String date = sdf.format(c.getTime());  // dt is now the new date
            type(calDateField, date);
            selectEmployee.selectByValue("218");
            type(inTimeField, inTime);
            type(outTimeField, outTime);
            selectScheduleActivity.selectByVisibleText("Work Time");
            selectActualActivity.selectByVisibleText("Work Time");
            saveBut.click();
        }

    }


}
