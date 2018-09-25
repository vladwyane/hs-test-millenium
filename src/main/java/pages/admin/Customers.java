package pages.admin;

import data.Franchisee;
import data.Users;
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
public class Customers extends BasePage {

    public Customers(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("adminCustomers.url"));
    }

    @FindBy(name = "FranchiseeCustomerSearch[email]")
    private TextInput emailSearchField;

    @Name("ArrayList of reset link")
    @FindBys( {@FindBy(css = "a.reset-password")} )
    private List<HtmlElement> listResetLink;

    @FindBy(css = "button.confirm")
    private HtmlElement confirmPopupBut;

    private void searchCustomers (String userEmail) {
        type(emailSearchField, userEmail + Keys.ENTER);
        waitUntilTextInElementAppear(listResetLink.get(0), "waiting");
    }

    private void clickResetPassword () {
        listResetLink.get(0).click();
        waitUntilTextInElementAppear(listResetLink.get(0), "waiting");
        confirmPopupBut.click();
        waitUntilTextInElementAppear(listResetLink.get(0), "waiting");
        confirmPopupBut.click();
    }

    public void sendResetPasswordLetter (Users users) {
        searchCustomers(users.getEmail());
        clickResetPassword();
    }
}
