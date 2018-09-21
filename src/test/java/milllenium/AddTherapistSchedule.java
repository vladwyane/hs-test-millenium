package milllenium;
import data.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.millenium.Dashboard;
import pages.millenium.LogInHome;
import pages.millenium.ScheduleEditor;
import testBase.TestBase;

import java.text.ParseException;

/**
 * Created by bigdrop on 9/21/2018.
 */
public class AddTherapistSchedule extends TestBase {

        private LogInHome logInHome;
        private Dashboard dashboard;
        private ScheduleEditor scheduleEditor;

        @BeforeMethod
        public void initPageObjects() {
            logInHome = new LogInHome(app.getDriver());
            dashboard = new Dashboard(app.getDriver());
            scheduleEditor = new ScheduleEditor(app.getDriver());
        }

        @Test()
        public void testCreateTherapistSchedule() throws InterruptedException, ParseException {
            logInHome.logIn(Users.MILLENIUM);
            dashboard.moveToScheduleEditor();
            scheduleEditor.addScheduleForDwyaneOnWeek("9/23/2018", "11:30 AM", "6:45 PM");
        }

}
