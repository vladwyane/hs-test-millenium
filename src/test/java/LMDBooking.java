import data.CreditCards;
import data.LocationsData;
import data.Users;
import io.qameta.allure.*;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import pages.booking.ChooseServices;
import pages.booking.Confirmation;
import pages.booking.PaymentInformation;
import pages.booking.PrefferedDateTime;
import testBase.TestBase;

/**
 * Created by bigdrop on 9/18/2018.
 */
@Epic("Regression Tests")
@Feature("LMDBooking Tests")
public class LMDBooking extends TestBase {

    private Home home;
    private CreateAccountPage createAccountPage;
    private GoogleMail googleMail;
    private FacialServicePage facialServicePage;
    private MassageServicePage massageServicePage;
    private ChooseServices chooseServices;
    private PrefferedDateTime prefferedDateTime;
    private PaymentInformation paymentInformation;
    private Confirmation confirmation;
    private Locations locations;
    private SignInPage signInPage;
    private LastDealsPage lastDealsPage;

    @BeforeMethod
    public void initPageObjects() {
        home = new Home(app.getDriver());
        createAccountPage = new CreateAccountPage(app.getDriver());
        googleMail = new GoogleMail(app.getDriver());
        facialServicePage = new FacialServicePage(app.getDriver());
        massageServicePage = new MassageServicePage(app.getDriver());
        chooseServices = new ChooseServices(app.getDriver());
        prefferedDateTime = new PrefferedDateTime(app.getDriver());
        paymentInformation = new PaymentInformation(app.getDriver());
        confirmation = new Confirmation(app.getDriver());
        locations = new Locations(app.getDriver());
        signInPage = new SignInPage(app.getDriver());
        lastDealsPage = new LastDealsPage(app.getDriver());
    }

    @AfterMethod
    public void clearAllCookies() {
        app.delleteAllCookies();
    }

    @Test()
    @Severity(SeverityLevel.MINOR)
    @Story("Negative test of LMD booking with not found location")
    public void testLMDBookingNothingFound() throws InterruptedException {
        home.open();
        locations.clickLocationItemFromMainNav();
        locations.chooseLocationFromLocationPage(LocationsData.CHERRY_HILL);
        home.open();
        home.checkingNothingFoundSection();
    }

    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of LMD booking from home page")
    public void testLMDBookingFromHomePage() throws InterruptedException {
        locations.open();
        locations.chooseLocationFromLocationPage(LocationsData.CHERRY_HILL);
        home.open();
        home.chooseFirstLMDServiceFromAvailable();
        paymentInformation.fillPaymentInformation(Users.LEBRON, CreditCards.VISA_STRIPE, false);
        confirmation.checkingSuccessLMDBooking();
    }

    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of LMD booking from spa deals page")
    public void testLMDBookingFromSpaDealsPage() throws InterruptedException {
        home.open();
        lastDealsPage.clickSpaDealsItemFromMainNav();
        createAccountPage.chooseLocation(LocationsData.CHERRY_HILL);
        lastDealsPage.chooseFirstLMDServiceFromAvailable();
        paymentInformation.fillPaymentInformation(Users.LEBRON, CreditCards.VISA_STRIPE, false);
        confirmation.checkingSuccessLMDBooking();
    }

    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of LMD booking from location page")
    public void testLMDBookingFromLocationPage() throws InterruptedException {
        locations.open();
        locations.moveToLocationDetail(LocationsData.CHERRY_HILL);
        home.chooseFirstLMDServiceFromAvailable();
        paymentInformation.fillPaymentInformation(Users.LEBRON, CreditCards.VISA_STRIPE, false);
        confirmation.checkingSuccessLMDBooking();
    }
}
