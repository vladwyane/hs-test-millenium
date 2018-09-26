package adminPanel;

import data.Franchisee;
import data.Users;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.GoogleMail;
import pages.Home;
import pages.admin.AdminLogIn;
import pages.admin.Customers;
import pages.admin.FranchiseeList;
import pages.admin.MillenniumPOS;
import testBase.TestBase;

/**
 * Created by bigdrop on 9/25/2018.
 */
@Epic("Regression Tests")
@Feature("Admin Customers Test")
public class CustomersAction extends TestBase {

    private AdminLogIn adminLogIn;
    private FranchiseeList franchiseeList;
    private Customers customers;
    private GoogleMail googleMail;
    private Home home;

    @BeforeMethod
    public void initPageObjects() {
        adminLogIn = new AdminLogIn(app.getDriver());
        franchiseeList = new FranchiseeList(app.getDriver());
        customers = new Customers(app.getDriver());
        googleMail = new GoogleMail(app.getDriver());
        home = new Home(app.getDriver());
    }

    @AfterMethod
    public void clearAllCookies() {
        app.delleteAllCookies();
    }

    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of sending reset password from admin panel")
    public void testSendingResetPassword() throws InterruptedException {
        adminLogIn.logInToAdmin(Users.ADMIN);
        franchiseeList.open();
        franchiseeList.searchFranchisee(Franchisee.CHERRY_HILL);
        customers.open();
        customers.sendResetPasswordLetter(Users.LEBRON);
        googleMail.signIntoGoogleMail(Users.VLADYSLAV);
        googleMail.checkingEmailResetPassword();
    }

    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of reset new password")
    public void testSuccessResetNewPassword() throws InterruptedException {
        googleMail.signIntoGoogleMail(Users.VLADYSLAV);
        app.getDriver().navigate().to(googleMail.returnResetPassLink());
        home.resetNewPassword(Users.LEBRON);
        home.checkingSuccessRessetPassword();
    }

}
