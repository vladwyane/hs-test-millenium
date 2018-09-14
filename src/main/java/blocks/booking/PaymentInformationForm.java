package blocks.booking;

import data.Users;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.account.Information;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

/**
 * Created by bigdrop on 9/14/2018.
 */
@Block(@FindBy(className = "booking-payment-form"))
public class PaymentInformationForm extends HtmlElement {

    public TextInput getCardNameField() {
        return cardNameField;
    }

    @FindBy(id = "form-payment-card-name")
    private TextInput cardNameField;

    public TextInput getCardNumberField() {
        return cardNumberField;
    }

    @FindBy(id = "form-payment-card-number")
    private TextInput cardNumberField;

    public TextInput getCardCVVField() {
        return cardCVVField;
    }
    @FindBy(id = "form-payment-cvv")
    private TextInput cardCVVField;

    public TextInput getZipCodeField() {
        return zipCodeField;
    }

    @FindBy(id = "form-payment-zip")
    private TextInput zipCodeField;

    @FindBy(xpath = "//select[@data-stripe='exp_month']//following-sibling::span")
    private HtmlElement monthSelect;

    @FindBy(xpath = "//select[@data-stripe='exp_year']//following-sibling::span")
    private HtmlElement yearsSelect;

    @Name("ArrayList of months")
    @FindBys( {@FindBy(xpath = "//div[contains(@class, 'jcf-select-month')]//li")} )
    public List<HtmlElement> listMonths;

    @Name("ArrayList of years")
    @FindBys( {@FindBy(xpath = "//div[contains(@class, 'jcf-select-drop')]//li")} )
    public List<HtmlElement> listYears;


    public void chooseMonth(String monthName) throws StaleElementReferenceException {
        monthSelect.click();
        try {
            for(WebElement element : listMonths) {
                if(element.getText().equals(monthName) || element.getText().equals(listMonths.get(listMonths.size() - 1).getText())) {
                    element.click();
                    return;
                }
            }
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){}
    }

    public void chooseYear(String yearName) throws StaleElementReferenceException {
        yearsSelect.click();
        try {
            for(WebElement element : listYears) {
                if(element.getText().equals(yearName) || element.getText().equals(listYears.get(listYears.size() - 1).getText())) {
                    element.click();
                    return;
                }
            }
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){}
    }
}
