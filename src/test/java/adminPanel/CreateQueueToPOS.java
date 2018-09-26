package adminPanel;

import data.Users;
import org.aspectj.lang.annotation.After;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.admin.AdminLogIn;
import pages.admin.MillenniumPOS;
import pages.millenium.Dashboard;
import testBase.TestBase;

/**
 * Created by bigdrop on 9/21/2018.
 */
public class CreateQueueToPOS extends TestBase {

    private AdminLogIn adminLogIn;
    private MillenniumPOS millenniumPOS;

    @BeforeMethod
    public void initPageObjects() {
        adminLogIn = new AdminLogIn(app.getDriver());
        millenniumPOS = new MillenniumPOS(app.getDriver());
    }

    @AfterMethod
    public void clearAllCookies() {
        app.delleteAllCookies();
    }

    @Test(priority = 5)
    public void testQueueTherapistSchedules() {
        adminLogIn.logInToAdmin(Users.ADMIN);
        millenniumPOS.open();
        millenniumPOS.makeQueueToPOS("therapist-schedules");
    }

    @Test(priority = 5)
    public void testQueueEmpAndTherapistServices() {
        adminLogIn.logInToAdmin(Users.ADMIN);
        millenniumPOS.open();
        millenniumPOS.makeQueueToPOS("therapist");
        millenniumPOS.makeQueueToPOS("therapist-service");
    }

    @Test(priority = 5)
    public void testQueueServices() {
        adminLogIn.logInToAdmin(Users.ADMIN);
        millenniumPOS.open();
        millenniumPOS.makeQueueToPOS("service");
    }

    @Ignore
    @Test(priority = 5)
    public void testQueueResetMapping() {
        adminLogIn.logInToAdmin(Users.ADMIN);
        millenniumPOS.open();
        millenniumPOS.makeQueueToPOS("reset-mapping");
    }
}
