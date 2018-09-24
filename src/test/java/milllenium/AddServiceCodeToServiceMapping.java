package milllenium;

import data.ServicesData;
import data.Users;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.admin.AdminLogIn;
import pages.admin.MillenniumPOS;
import pages.admin.ServiceMapping;
import testBase.TestBase;

public class AddServiceCodeToServiceMapping extends TestBase {

    private AdminLogIn adminLogIn;
    private ServiceMapping serviceMapping;

    @BeforeMethod
    public void initPageObjects() {
        adminLogIn = new AdminLogIn(app.getDriver());
        serviceMapping = new ServiceMapping(app.getDriver());
    }

    @AfterMethod
    public void clearAllCookies() {
        app.delleteAllCookies();
    }

    @Test(priority = 4)
    public void testQueueTherapistSchedules() {
        adminLogIn.logInToAdmin(Users.ADMIN);
        serviceMapping.open();
        serviceMapping.addCodeSerToNonMember(ServicesData.NCHS80);
    }
}
