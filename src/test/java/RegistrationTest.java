import data.Users;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.CreateAccount;
import pages.Home;
import pages.popUps.InfoPopup;
import testBase.TestBase;

/**
 * Created by bigdrop on 8/31/2018.
 */
public class RegistrationTest extends TestBase{

    private Home home = PageFactory.initElements(initDriver(), Home.class);
    private CreateAccount createAccount = PageFactory.initElements(initDriver(), CreateAccount.class);
    private InfoPopup infoPopup = PageFactory.initElements(initDriver(), InfoPopup.class);

    @Test(description = "Test of success registration")
    public void testSuccessRegistration() throws InterruptedException {
        home.open();
        createAccount.registration(Users.LEBRON);
        infoPopup.checkingSuccessOfRegistration();
    }
}
