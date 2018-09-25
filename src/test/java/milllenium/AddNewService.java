package milllenium;

import data.ServicesData;
import data.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.millenium.Dashboard;
import pages.millenium.LogInHome;
import pages.millenium.ServicesPOS;
import testBase.TestBase;

/**
 * Created by bigdrop on 9/24/2018.
 */
public class AddNewService extends TestBase {

    private LogInHome logInHome;
    private ServicesPOS servicesPOS;
    private Dashboard dashboard;

    @BeforeMethod
    public void initPageObjects() {
        logInHome = new LogInHome(app.getDriver());
        servicesPOS = new ServicesPOS(app.getDriver());
        dashboard = new Dashboard(app.getDriver());
    }

    @Test(priority = 1)
    public void testCreateService() {
        logInHome.logIn(Users.MILLENIUM);
        dashboard.moveToServices();
        servicesPOS.createNewService(ServicesData.NCHS80);
    }
}
