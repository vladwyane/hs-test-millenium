import data.Users;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleMail;
import pages.Home;
import pages.SignInPage;
import pages.account.Dashboard;
import pages.account.Information;
import testBase.TestBase;

/**
 * Created by bigdrop on 9/4/2018.
 */
@Epic("Regression Tests")
@Feature("SignIn Tests")
public class SignIn extends TestBase {

    private Home home;
    private SignInPage signInPage;
    private Dashboard dashboard;
    private Information information;
    private GoogleMail googleMail;

    @BeforeMethod
    public void initPageObjects() {
        signInPage = new SignInPage(app.getDriver());
        home = new Home(app.getDriver());
        dashboard = new Dashboard(app.getDriver());
        information = new Information(app.getDriver());
        googleMail = new GoogleMail(app.getDriver());
    }

    @AfterMethod
    public void logOut() {
        dashboard.logOut();
    }

    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of login from sign in popup")
    public void testSuccessLogInFromSignInPopup() throws InterruptedException {
        home.open();
        signInPage.openSignInPopup();
        signInPage.logInFromSignInPopup(Users.LEBRON);
        dashboard.checkingAccountDashboard(Users.LEBRON);
    }

    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of login from sign in page")
    public void testSuccessLogInFromSignInPage() throws InterruptedException {
        signInPage.open();
        signInPage.logIn(Users.DWYANE);
        dashboard.clickAccInfoLink();
        information.checkAccountContactInfo(Users.DWYANE);
    }

    @Test()
    @Severity(SeverityLevel.MINOR)
    @Story("Positive test of update contact information")
    public void testSuccessUpdateContactInfo() throws InterruptedException {
        signInPage.open();
        signInPage.logIn(Users.DWYANE);
        dashboard.clickAccInfoLink();
        information.updateContactInfo(Users.DWYANE);
        information.checkingSuccessPopup();
    }

    @Test()
    @Severity(SeverityLevel.MINOR)
    @Story("Positive test of changed password")
    public void testSuccessChangePassword() throws InterruptedException {
        signInPage.open();
        signInPage.logIn(Users.LEBRON);
        dashboard.clickAccInfoLink();
        information.changePassword(Users.LEBRON_UPDATE);
        information.checkingSuccessPopup();
    }

    @Test()
    @Severity(SeverityLevel.MINOR)
    @Story("Test of email with changed password")
    public void testSuccessEmailChangePassword() throws InterruptedException {
        googleMail.signIntoGoogleMail(Users.VLADYSLAV);
        googleMail.checkingEmailChangePass();
    }

}
