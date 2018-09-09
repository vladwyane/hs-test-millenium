import data.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;
import pages.SignInPage;
import testBase.TestBase;

/**
 * Created by bigdrop on 9/4/2018.
 */

public class SignInTest extends TestBase {

    private Home home;
    private SignInPage signInPage;

    @BeforeMethod
    public void initPageObjects() {
        signInPage = new SignInPage(app.getDriver());
        home = new Home(app.getDriver());
    }

    @Test()
    public void testSuccessLogInFromSignInPopup() {
        home.open();
        signInPage.openSignInPopup();
        signInPage.logInFromSignInPopup(Users.LEBRON);
    }

    @Test()
    public void testSuccessLogInFromSignInPage() throws InterruptedException {
        signInPage.open();
        signInPage.logIn(Users.DWYANE);
    }
}
