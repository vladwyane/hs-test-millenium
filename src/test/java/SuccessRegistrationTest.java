import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Users;
import data.UsersData;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccount;
import pages.Home;
import pages.SignIn;
import pages.popUps.InfoPopup;
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

    private Home home = PageFactory.initElements(initDriver(), Home.class);
    private CreateAccount createAccount = PageFactory.initElements(initDriver(), CreateAccount.class);
    private InfoPopup infoPopup = PageFactory.initElements(initDriver(), InfoPopup.class);
    private SignIn signIn = PageFactory.initElements(initDriver(), SignIn.class);

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

    @Test(priority = 1, alwaysRun = true)
    public void testSuccessRegistrationFromSignUpPage() throws InterruptedException {
        home.open();
        createAccount.openRegistrationPage();
        createAccount.registration(Users.LEBRON);
        infoPopup.checkingSuccessOfRegistration();
    }

    @Test(priority = 1, alwaysRun = true)
    public void testSuccessRegistrationFromSignInPage() throws InterruptedException {
        signIn.openCreateAccPageFromSignIn();
        createAccount.registration(Users.DWYANE);
        infoPopup.checkingSuccessOfRegistration();
    }


}