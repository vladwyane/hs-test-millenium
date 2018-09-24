package milllenium;

import data.Therapist;
import data.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.millenium.Dashboard;
import pages.millenium.Employee;
import pages.millenium.LogInHome;
import testBase.TestBase;

/**
 * Created by bigdrop on 9/21/2018.
 */
public class AddNewTherapist extends TestBase {

    private LogInHome logInHome;
    private Employee employee;
    private Dashboard dashboard;

    @BeforeMethod
    public void initPageObjects() {
        logInHome = new LogInHome(app.getDriver());
        employee = new Employee(app.getDriver());
        dashboard = new Dashboard(app.getDriver());
    }

    @Test(priority = 2)
    public void testCreateTherapist() {
        logInHome.logIn(Users.MILLENIUM);
        dashboard.moveToEmployee();
        employee.createNewMaleTherapist(Therapist.VLADYSLAV);
        employee.addingAllServiceForTherapist("Allowed?");
    }
}
