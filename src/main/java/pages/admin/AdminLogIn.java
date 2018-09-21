package pages.admin;

import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.millenium.Dashboard;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 9/21/2018.
 */
public class AdminLogIn extends BasePage {

    public AdminLogIn(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("adminLogIn.url"));
    }

    @FindBy(id = "loginform-email")
    private TextInput adminEmailField;

    @FindBy(id = "loginform-password")
    private TextInput adminPasswordField;

    @FindBy(name = "btnSubmit")
    private Button signOnBut;

    public AdminDashboad logInToAdmin(Users users) {
        open();
        type(adminEmailField, users.getEmail());
        type(adminPasswordField, users.getNewPassword());
        signOnBut.click();
        return new AdminDashboad(driver);
    }
}
