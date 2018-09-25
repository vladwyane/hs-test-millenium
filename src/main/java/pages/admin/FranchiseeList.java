package pages.admin;

import data.Franchisee;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import utils.ConfigProperties;

import java.util.List;

/**
 * Created by bigdrop on 9/25/2018.
 */
public class FranchiseeList extends BasePage {

    public FranchiseeList(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("adminFranchisee.url"));
    }

    @FindBy(name = "FranchiseeSearch[name]")
    private TextInput franchNameSearchField;

    @Name("ArrayList of login buttons")
    @FindBys( {@FindBy(xpath = "//a[contains(text(), 'Login')]")} )
    private List<HtmlElement> listLoginBut;

    public void searchFranchisee (Franchisee franchisee) {
        type(franchNameSearchField, franchisee.getFaranchiseeName() + Keys.ENTER);
        waitUntilTextInElementAppear(listLoginBut.get(0), "waiting");
        listLoginBut.get(0).click();
    }
}
