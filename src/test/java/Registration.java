import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.LocationsData;
import data.Users;
import data.UsersData;
import io.qameta.allure.*;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;
import pages.*;
import testBase.TestBase;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bigdrop on 8/31/2018.
 */
@Epic("Regression Tests")
@Feature("Registration Tests")
public class Registration extends TestBase{

    private Home home;
    private SignInPage signInPage;
    private CreateAccountPage createAccountPage;
    private GoogleMail googleMail;

    @BeforeMethod
    public void initPageObjects() {
        home = new Home(app.getDriver());
        signInPage = new SignInPage(app.getDriver());
        createAccountPage = new CreateAccountPage(app.getDriver());
        googleMail = new GoogleMail(app.getDriver());
    }

    @DataProvider
    public Iterator<Object[]> validUsers() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/users.csv")));
        String line = reader.readLine();
        while(line != null) {
            String[] split = line.split(";");
            list.add(new Object[] {new UsersData().setFirstName(split[0]).setLastName(split[1]).setEmail(split[2]).setPassword(split[3])
                    .setConfPassword(split[4]).setPhone(split[5]).setLocation(split[6])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validUsersFromJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/users.json")));
        String json = "";
        String line = reader.readLine();
        while(line != null) {
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<UsersData> usersData = gson.fromJson(json, new TypeToken<List<UsersData>>(){}.getType());
        return usersData.stream().map((u) -> new Object[] {u}).collect(Collectors.toList()).iterator();
    }

    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of registration from sign up page without chosen location")
    public void testSuccessRegistrationFromSignUpPage() {
        home.open();
        createAccountPage.openRegistrationPage();
        createAccountPage.registration(Users.LEBRON);
        createAccountPage.checkingSuccessOfRegistration();
    }

    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of registration from sign in page with chosen location")
    public void testSuccessRegistrationFromSignInPage() {
        signInPage.openCreateAccPageFromSignIn();
        createAccountPage.registrationWithLocation(Users.DWYANE, LocationsData.CHERRY_HILL);
        createAccountPage.checkingSuccessOfRegistration();
    }

    @Test()
    @Severity(SeverityLevel.MINOR)
    @Story("Negative test of registration with all blank fields")
    public void testErrorRegistrationAllFieldsBlank() {
        createAccountPage.open();
        createAccountPage.clickCreateAccButWithEmptyFields();
        createAccountPage.checkingErrorNotesAllFieldsAreBlank();
    }

    @Test()
    @Severity(SeverityLevel.MINOR)
    @Story("Negative test of registration with not match password")
    public void testErrorRegistrationNotMatchPassword() {
        createAccountPage.open();
        createAccountPage.registration(Users.INVALID);
        createAccountPage.checkingErrorNoteNotMatchPassword();
    }

    @Test()
    @Severity(SeverityLevel.MINOR)
    @Story("Negative test of registration with exist email")
    public void testErrorRegistrationExistEmail() {
        signInPage.openCreateAccPageFromSignIn();
        createAccountPage.open();
        createAccountPage.registration(Users.LEBRON);
        createAccountPage.checkingErrorNoteExistEmail(Users.LEBRON);
    }

    @Test()
    @Severity(SeverityLevel.MINOR)
    @Story("Test of email with registration letter")
    public void testSuccessEmailRegistration() throws InterruptedException {
        googleMail.signIntoGoogleMail(Users.VLADYSLAV);
        googleMail.checkingEmailRegistration();
    }

}
