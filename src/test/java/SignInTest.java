import data.Users;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.SignIn;
import pages.popUps.SignInPopup;
import testBase.TestBase;

/**
 * Created by bigdrop on 9/4/2018.
 */
public class SignInTest extends TestBase {

    private SignIn signIn = PageFactory.initElements(initDriver(), SignIn.class);
    private SignInPopup signInPopup = PageFactory.initElements(initDriver(), SignInPopup.class);

    @Test(alwaysRun = true)
    public void testSuccessLogInFromSignInPopup() throws InterruptedException {
        signInPopup.open();
        signInPopup.logIn(Users.LEBRON);
    }

    @Test(alwaysRun = true)
    public void testSuccessLogInFromSignInPage() throws InterruptedException {
        signIn.open();
        signIn.logIn(Users.DWYANE);
    }
}
