import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Users;
import data.UsersData;
import org.testng.annotations.*;
import pages.CreateAccountPage;
import pages.Home;
import pages.SignInPage;
import testBase.TestBase;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bigdrop on 8/31/2018.
 */
public class SuccessRegistrationTest extends TestBase{

    private Home home;
    private SignInPage signInPage;
    private CreateAccountPage createAccountPage;

    @BeforeMethod
    public void initPageObjects() {
        home = new Home(app.getDriver());
        signInPage = new SignInPage(app.getDriver());
        createAccountPage = new CreateAccountPage(app.getDriver());
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

    @Test(priority = 1)
    public void testSuccessRegistrationFromSignUpPage() throws InterruptedException {
        home.open();
        createAccountPage.openRegistrationPage();
        createAccountPage.registration(Users.LEBRON);
        createAccountPage.checkingSuccessOfRegistration();
    }


    @Test(priority = 1)
    public void testSuccessRegistrationFromSignInPage() throws InterruptedException {
        signInPage.openCreateAccPageFromSignIn();
        createAccountPage.registration(Users.DWYANE);
        createAccountPage.checkingSuccessOfRegistration();
    }

    @Test(priority = 2)
    public void testErrorRegistrationAllFieldsBlank() {
        createAccountPage.open();
        createAccountPage.clickCreateAccButWithEmptyFields();
        createAccountPage.checkingErrorNotesAllFieldsAreBlank();
    }

    @Test(priority = 2)
    public void testErrorRegistrationNotMatchPassword() {
        createAccountPage.open();
        createAccountPage.registration(Users.INVALID);
        createAccountPage.checkingErrorNoteNotMatchPassword();
    }

    @Test(priority = 2)
    public void testErrorRegistrationExistEmail() {
        createAccountPage.open();
        createAccountPage.registration(Users.LEBRON);
        createAccountPage.checkingErrorNoteExistEmail(Users.LEBRON);
    }


}
