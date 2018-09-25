package pages.millenium;

import blocks.Header;
import data.ServicesData;
import data.Therapist;
import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;

import java.util.List;

/**
 * Created by bigdrop on 9/21/2018.
 */
public class Employee extends BasePage {

    public Employee(WebDriver driver) {
        super(driver);
    }

    Header header;

    @Override
    public void open() {

    }

    @FindBy(xpath = "//input[@value='New']")
    private Button newEmployeeBut;

    @FindBy(xpath = "//select[contains(@id, 'Location_lstAvailable')]")
    private Select selectLocationAvailable;

    @FindBy(xpath = "//input[@id='ctl00_Main_cntLocation_btnAdd']")
    private Button addLocationBut;

    @FindBy(id = "ctl00_Main_txtCode")
    private TextInput codeField;

    @FindBy(id = "ctl00_Main_txtFirstName")
    private TextInput firstNameField;

    @FindBy(id = "ctl00_Main_txtLastName")
    private TextInput lastNameField;

    @Name("ArrayList of show setting checkbox")
    @FindBys( {@FindBy(css = "#Table6 input")} )
    private List<CheckBox> listShowSettingsCheckBox;

    @FindBy(id = "ctl00_Main_rblSex_0")
    private Radio radioButSex;

    @FindBy(xpath = "//td[contains(text(), 'Massage Therapist')]/preceding-sibling::td")
    private CheckBox checkMassTher;

    @FindBy(xpath = "//a[contains(text(), 'Appts & Services')]")
    private Link appServiceLink;

    @FindBy(xpath = "//input[@value='Save']")
    private Button saveEmpBut;

    @FindBy(xpath = "//input[@value='Edit']")
    private Button editServBut;

    @Name("ArrayList of service checkbox")
    @FindBys( {@FindBy(xpath = "//input[contains(@id, 'Services')]")} )
    private List<CheckBox> listServiceCheckBox;

    @Name("ArrayList of header service table")
    @FindBys( {@FindBy(css = ".headerrow td")} )
    private List<HtmlElement> listHeaderTableService;

    @Name("ArrayList of footer pagination item")
    @FindBys( {@FindBy(css = ".footerrow2 a")} )
    private List<HtmlElement> listFooterPaginItem;

    @Name("ArrayList of all td in table after checkbox")
    @FindBys( {@FindBy(xpath = "//input[contains(@id, 'Services')]//ancestor::td[@align and not (@class)]//following-sibling::td")} )
    private List<HtmlElement> lisTdAfterCheckbox;

    @FindBy(id = "ctl00_Main_btnPage4CopyServs")
    private Button copyAllowedServBut;

    @FindBy(id = "ctl00_Main_cntPage4Employees_cboEmployees")
    private Select selectEmployee;

    public int getNumColumnFormTable(String headingColumn) {
        int indexColumn = 0;
        for (int i = 0; i < listHeaderTableService.size(); i++) {
            if(listHeaderTableService.get(i).getText().contains(headingColumn)){
                indexColumn = i;
                break;
            }
        }
        return indexColumn;
    }

    public void chooseAllService(String headingColumn) {
        appServiceLink.click();
        editServBut.click();
        int indexColumn = getNumColumnFormTable(headingColumn);
        int i = 0;
        do {
            for (int j = indexColumn; j < listServiceCheckBox.size(); j += (listServiceCheckBox.size() / listHeaderTableService.size())) {
                if( listServiceCheckBox.get(j).isSelected() == false)
                    listServiceCheckBox.get(j).select();
            }
            if(listFooterPaginItem.get(listFooterPaginItem.size() - 1).getText().equals("...") == false) {
                break;
            }
            if(listFooterPaginItem.get(i).getText().equals("...")) {
                listFooterPaginItem.get(i).click();
                i = 1;
            }
            else {
                listFooterPaginItem.get(i).click();
                i++;
            }
        } while (i < listFooterPaginItem.size());
        saveEmpBut.click();
        waitUntilElementAppeared(header);
    }

    public void chooseLocationByValue(String value) {
        selectLocationAvailable.selectByValue(value);
        addLocationBut.click();
    }

    public void fillingTherapistContactInfo(Therapist therapist) {
        type(codeField, therapist.getTherapistCode().toUpperCase());
        type(firstNameField, therapist.getTherapistFirstName());
        type(lastNameField, therapist.getTherapistLastName());
    }

    public void chooseGender(Therapist therapist) {
        if(therapist.getTherapistSpecific().equals("Any Male"))
            radioButSex.selectByValue("1");
        else radioButSex.selectByValue("2");
    }

    public void selectAllShowSettingCheckBox() {
        for (int i = 0; i < listShowSettingsCheckBox.size(); i++) {
            if(listShowSettingsCheckBox.get(i).isSelected() == false)
                listShowSettingsCheckBox.get(i).select();
        }
    }

    public void createNewMaleTherapist(Therapist therapist) {
        newEmployeeBut.click();
        chooseLocationByValue("2");
        fillingTherapistContactInfo(therapist);
        checkMassTher.select();
        selectAllShowSettingCheckBox();
        chooseGender(therapist);
        saveEmpBut.click();
    }

    public void addingAllServiceForTherapist() {
        chooseAllService("Allowed?");
    }

    public void addingService(ServicesData servicesData) {
        chooseService(servicesData.getCodeService().toUpperCase());
    }

    private void chooseService(String serviceCode) {
        appServiceLink.click();
        editServBut.click();
        int i = 0;
        do {
            for (int j = 0; j < lisTdAfterCheckbox.size(); j += (lisTdAfterCheckbox.size() / 10)) {
                if(lisTdAfterCheckbox.get(j).getText().equals(serviceCode) && listServiceCheckBox.get(((j / (lisTdAfterCheckbox.size() / 10)) * (listServiceCheckBox.size() / 10))).isSelected() == false) {
                    listServiceCheckBox.get(((j / (lisTdAfterCheckbox.size() / 10)) * (listServiceCheckBox.size() / 10))).select();
                    saveEmpBut.click();
                    waitUntilElementAppeared(header);
                    return;
                }
            }
            if(listFooterPaginItem.get(listFooterPaginItem.size() - 1).getText().equals("...") == false) {
                break;
            }
            if(listFooterPaginItem.get(i).getText().equals("...")) {
                listFooterPaginItem.get(i).click();
                i = 1;
            }
            else {
                listFooterPaginItem.get(i).click();
                i++;
            }
        } while (i < listFooterPaginItem.size());
    }

    public void chooseServiceFromAnotherEmp(Therapist therapist) {
        appServiceLink.click();
        editServBut.click();
        copyAllowedServBut.click();
        waitUntilTextInElementAppear(header, "waiting");
        selectEmployee.selectByVisibleText(therapist.getTherapistCode().toUpperCase() + ": " + therapist.getTherapistLastName() + ", " + therapist.getTherapistFirstName());
        saveEmpBut.click();
        waitUntilElementAppeared(header);
    }
}
