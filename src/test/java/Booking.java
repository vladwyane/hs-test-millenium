import data.*;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.account.Dashboard;
import pages.booking.ChooseServices;
import pages.booking.Confirmation;
import pages.booking.PaymentInformation;
import pages.booking.PrefferedDateTime;
import testBase.TestBase;

/**
 * Created by bigdrop on 9/14/2018.
 */
@Epic("Regression Tests")
@Feature("Bocking Tests")
public class Booking extends TestBase {

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
    private Dashboard dashboard;

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
        dashboard = new Dashboard(app.getDriver());
    }

    @AfterMethod
    public void clearAllCookies() {
        app.delleteAllCookies();
    }

    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of booking with creating account")
    public void testBookingWithRegistration() throws InterruptedException {
        home.open();
        locations.clickLocationItemFromMainNav();
        locations.chooseLocationFromLocationPage(LocationsData.DE_BEAR);
        locations.changeLocation(LocationsData.CHERRY_HILL);
        facialServicePage.clickFacialService();
        chooseServices.chooseServiceAsGuest(ServicesData.NMTFC, false);
        String therapistName = prefferedDateTime.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.SEPTEMBER26_02PM);
        paymentInformation.fillPaymentInformation(Users.ALLEN, CreditCards.VISA_STRIPE, true);
        signInPage.open();
        signInPage.logIn(Users.ALLEN);
        dashboard.checkingAppointments(DateTime.SEPTEMBER26_02PM, therapistName, ServicesData.NMTFC, LocationsData.CHERRY_HILL);
    }

    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of booking as guest")
    public void testBookingAsGuest() throws InterruptedException {
        home.open();
        massageServicePage.clickMassageService();
        createAccountPage.chooseLocation(LocationsData.CHERRY_HILL);
        chooseServices.chooseServiceAsGuest(ServicesData.NM80, true);
        String therapistName = prefferedDateTime.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.SEPTEMBER26_02PM);
        paymentInformation.fillPaymentInformation(Users.LEBRON, CreditCards.VISA_STRIPE, false);
        confirmation.checkingSuccessBooking(LocationsData.CHERRY_HILL, ServicesData.NM80, therapistName, DateTime.SEPTEMBER26_02PM);
    }

    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of booking as member")
    public void testBookingAsMember() throws InterruptedException {
        home.open();
        locations.clickLocationItemFromMainNav();
        locations.chooseLocationFromLocationPage(LocationsData.CHERRY_HILL);
        massageServicePage.clickMassageService();
        chooseServices.chooseServiceAsMember(ServicesData.NM50, Users.MEMBER, false);
        String therapistName = prefferedDateTime.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.SEPTEMBER26_02PM);
        paymentInformation.fillPaymentInformationForMember();
        confirmation.checkingSuccessBooking(LocationsData.CHERRY_HILL, ServicesData.NM50, therapistName, DateTime.SEPTEMBER26_02PM);
    }

    @Test()
    @Severity(SeverityLevel.CRITICAL)
    @Story("Negative test of booking with invalid card")
    public void testBookingAsGuestWithInvalidCard() throws InterruptedException {
        home.open();
        facialServicePage.clickFacialService();
        createAccountPage.chooseLocation(LocationsData.CHERRY_HILL);
        chooseServices.chooseServiceAsGuest(ServicesData.NMTFC, true);
        prefferedDateTime.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.SEPTEMBER26_02PM);
        paymentInformation.fillPaymentInformation(Users.DWYANE, CreditCards.TEST_CARD, false);
        confirmation.checkingErrorBooking();
    }

    @Test()
    @Severity(SeverityLevel.MINOR)
    @Story("Test of email with success booking")
    public void testSuccessEmailBooking() throws InterruptedException {
        googleMail.signIntoGoogleMail(Users.VLADYSLAV);
        googleMail.checkingEmailBooking();
    }

}
