import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAccount;
import pages.Home;
import pages.SignIn;
import pages.popUps.InfoPopup;
import testBase.TestBase;

/**
 * Created by bigdrop on 9/5/2018.
 */
public class ErrorRegistrationTests extends TestBase{

    private Home home = PageFactory.initElements(initDriver(), Home.class);
    private CreateAccount createAccount = PageFactory.initElements(initDriver(), CreateAccount.class);
    private InfoPopup infoPopup = PageFactory.initElements(initDriver(), InfoPopup.class);
    private SignIn signIn = PageFactory.initElements(initDriver(), SignIn.class);


    @Test(priority = 2, alwaysRun = true)
    public void testErrorRegistrationAllFieldsBlank() throws InterruptedException {
        createAccount.open();
        createAccount.checkingErrorNotesAllFieldsAreBlank();
    }

    @Test(priority = 2, alwaysRun = true)
    public void testErrorRegistrationNotMatchPassword() throws InterruptedException {
        createAccount.open();
        createAccount.registration(Users.INVALID);
        createAccount.checkingErrorNoteNotMatchPassword();
    }

    @Test(priority = 2, alwaysRun = true)
    public void testErrorRegistrationExistEmail() throws InterruptedException {
        createAccount.open();
        createAccount.registration(Users.LEBRON);
        createAccount.checkingErrorNoteExistEmail(Users.LEBRON);
    }

}
