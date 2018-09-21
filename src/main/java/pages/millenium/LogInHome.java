package pages.millenium;

import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 9/21/2018.
 */
public class LogInHome extends BasePage{

    public LogInHome(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("milleniumLogIn.url"));
    }

    @FindBy(id = "txtUser")
    private TextInput userNameField;

    @FindBy(id = "txtPassword")
    private TextInput passwordField;

    @FindBy(id = "btnSignOn")
    private Button signOnBut;

    public Dashboard logIn(Users users) {
        open();
        type(userNameField, users.getFirstName());
        type(passwordField, users.getNewPassword());
        signOnBut.click();
        return new Dashboard(driver);
    }

}
