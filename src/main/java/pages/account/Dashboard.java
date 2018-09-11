package pages.account;

import blocks.Header;
import blocks.account.AccountIdInfo;
import blocks.account.DashboardInfo;
import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Link;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 9/10/2018.
 */
public class Dashboard extends BasePage {

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    private AccountIdInfo accountIdInfo;
    private DashboardInfo dashboardInfo;
    private Header header;

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("accountDashboard.url"));
    }

    @FindBy(xpath = "//div[@class='dashboard-menu']//a[@href='/account']")
    private Link dashboardLink;

    @FindBy(xpath = "//div[@class='dashboard-menu']//a[@href='/account/information']")
    private Link accInformationLink;

    public void clickAccInfoLink() {
        accInformationLink.click();
    }

    @FindBy(xpath = "//div[@class='dashboard-menu']//a[@href='/account/appointments']")
    private Link myAppointmentsLink;

    @FindBy(className = "logout")
    private Link logoutLink;

    public void clickLogoutLink() {
        logoutLink.click();
    }

    public void checkingAccountDashboard(Users users) {
        softAssert.assertEquals(dashboardInfo.getPhoneUser().getText(), splitPhoneNumToNewFormat(users));
        softAssert.assertEquals(dashboardInfo.getUserEmail().getText(), users.getEmail());
        softAssert.assertEquals(dashboardInfo.getChangePassLink().getReference(), ConfigProperties.getProperty("accountInformation.url"));
        softAssert.assertEquals(dashboardInfo.getUserStatus().getText(), "Non-member");
        softAssert.assertEquals(accountIdInfo.getUserName().getText(), users.getFirstName().toUpperCase());
        softAssert.assertEquals(accountIdInfo.getAccountPoints().getText(), "0");
        softAssert.assertEquals(dashboardLink.getReference(), ConfigProperties.getProperty("accountDashboard.url"));
        softAssert.assertEquals(accInformationLink.getReference(), ConfigProperties.getProperty("accountInformation.url"));
        softAssert.assertEquals(myAppointmentsLink.getReference(), ConfigProperties.getProperty("accountAppointments.url"));
        softAssert.assertEquals(logoutLink.getText(), "Logout");
        softAssert.assertAll();
    }

    public String splitPhoneNumToNewFormat(Users users) {
        String phoneNum = users.getPhone();
        char[] strToArray = phoneNum.toCharArray();
        String newPhoneNum = "";
        for (int i = 0; i < strToArray.length; i++) {
            if(i == 0)
                newPhoneNum += "(" + Character.toString(strToArray[i]);
            else if (i == 2)
                newPhoneNum += Character.toString(strToArray[i]) + ") ";
            else if(i == 5)
                newPhoneNum += Character.toString(strToArray[i]) + "-";
            else newPhoneNum += Character.toString(strToArray[i]);
        }
        return newPhoneNum;
    }

    public void logOut() {
        open();
        if (isElementPresent(dashboardInfo.getUserStatus()) == true) {
            clickLogoutLink();
        }
    }
}
