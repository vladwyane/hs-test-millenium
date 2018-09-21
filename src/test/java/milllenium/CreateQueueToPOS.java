package milllenium;

import data.Users;
import org.testng.annotations.BeforeMethod;
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

    @Test()
    public void testQueueTherapistSchedules() {
        adminLogIn.logInToAdmin(Users.ADMIN);
        millenniumPOS.open();
        millenniumPOS.makeQueueToPOS("therapist-schedules");
    }
}
