package pages.millenium;

import blocks.booking.Services;
import data.ServicesData;
import data.Therapist;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;

import java.util.List;

/**
 * Created by bigdrop on 9/24/2018.
 */
public class ServicesPOS extends BasePage {

    public ServicesPOS(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(xpath = "//input[@value='New']")
    private Button newServiceBut;

    @FindBy(xpath = "//select[contains(@id, 'Location_lstAvailable')]")
    private Select selectLocationAvailable;

    @FindBy(xpath = "//input[@id='ctl00_Main_cntLocation_btnAdd']")
    private Button addLocationBut;

    @FindBy(id = "ctl00_Main_txtCode")
    private TextInput codeServiceField;

    @FindBy(xpath = "//select[contains(@name, 'ServiceClass')]")
    private Select selectClassService;

    @FindBy(id = "ctl00_Main_txtDescription")
    private TextInput descriptionField;

    @FindBy(xpath = "//td[contains(text(), 'Massage')]/preceding-sibling::td")
    private CheckBox massageFormulaTypes;

    @FindBy(xpath = "//td[contains(text(), 'Facial')]/preceding-sibling::td")
    private CheckBox facialFormulaTypes;

    @FindBy(id = "ctl00_Main_cntLevel1_txtCurrency")
    private TextInput priceField;

    @FindBy(xpath = "//a[contains(text(), 'Appoint')]")
    private Link appointLink;

    @FindBy(xpath = "//input[@value='Save']")
    private HtmlElement saveServBut;

    @FindBy(id = "ctl00_Main_chkBookOnline")
    private CheckBox bookableCheckbox;

    @FindBy(id = "ctl00_Main_cntStartHr_txtSpinner")
    private HtmlElement hoursDurField;

    @FindBy(id = "ctl00_Main_cntStartMin_txtSpinner")
    private HtmlElement minuteDurField;


    public String returnHoursFromDuration(String duration) {
        String arr[] = duration.split(" ", 4);
        if(arr.length < 3)
            return "0";
        String Word = arr[0];
        return Word;
    }

    public String returnMinuteFromDuration(String duration) {
        String arr[] = duration.split(" ", 4);
        if(arr.length < 3)
            return arr[0];
        String Word = arr[2];
        return Word;
    }

    public void chooseLocationByValue(String value) {
        selectLocationAvailable.selectByValue(value);
        addLocationBut.click();
    }

    public void fillingServiceInfo(ServicesData servicesData) {
        type(codeServiceField, servicesData.getCodeService().toUpperCase());
        type(descriptionField, servicesData.getServiceName());
        type(priceField, servicesData.getPrice());
        selectClassService.selectByVisibleText(servicesData.getClassName().toUpperCase());
    }

    public void createNewService(ServicesData servicesData) {
        newServiceBut.click();
        chooseLocationByValue("2");
        fillingServiceInfo(servicesData);
        facialFormulaTypes.select();
        appointLink.click();
        changeAttributeValueWithJS(hoursDurField.getAttribute("id"), "value", returnHoursFromDuration(servicesData.getDuration()));
        changeAttributeValueWithJS(minuteDurField.getAttribute("id"), "value", returnMinuteFromDuration(servicesData.getDuration()));
        bookableCheckbox.select();
        saveServBut.click();
        waitUntilTextInElementAppear(saveServBut, "waiting");
    }


}
