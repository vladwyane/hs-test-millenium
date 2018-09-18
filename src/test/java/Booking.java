import data.CreditCards;
import data.Users;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.booking.ChooseServices;
import pages.booking.Confirmation;
import pages.booking.PaymentInformation;
import pages.booking.PrefferedDateTime;
import testBase.TestBase;

/**
 * Created by bigdrop on 9/14/2018.
 */
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
    }

    @AfterMethod
    public void clearAllCookies() {
        app.delleteAllCookies();
    }

    @Test()
    public void testBookingWithRegistration() throws InterruptedException {
        String locationName = "Cherry";
        String serviceName = "Men's Facial Clarity";
        String duration = "1 hour";
        String date = "Sep 20";
        home.open();
        locations.clickLocationItemFromMainNav();
        locations.chooseLocationFromLocationPage("Bear De");
        locations.changeLocation(locationName);
        facialServicePage.clickFacialService();
        chooseServices.chooseServiceAsGuest(serviceName, duration, false);
        String therapistName = prefferedDateTime.chooseTherapistAndDateTime("Any Employee", date, "12:00");
        paymentInformation.fillPaymentInformation(Users.ALLEN, CreditCards.VISA_STRIPE, true);
        confirmation.checkingSuccessBooking(locationName, serviceName, therapistName, duration, date);
    }

    @Test()
    public void testBookingAsGuest() throws InterruptedException {
        String locationName = "Cherry";
        String serviceName = "Massage";
        String duration = "1 hour 30 min";
        String date = "Sep 18";
        home.open();
        massageServicePage.clickMassageService();
        createAccountPage.chooseLocation(locationName);
        chooseServices.chooseServiceAsGuest(serviceName, duration, true);
        String therapistName = prefferedDateTime.chooseTherapistAndDateTime("Any Employee", date, "12:00");
        paymentInformation.fillPaymentInformation(Users.LEBRON, CreditCards.VISA_STRIPE, false);
        confirmation.checkingSuccessBooking(locationName, serviceName, therapistName, duration, date);
    }

    @Test()
    public void testBookingAsMember() throws InterruptedException {
        String locationName = "Cherry Hill";
        String serviceName = "Massage";
        String duration = "1 hour";
        String date = "Sep 18";
        home.open();
        locations.clickLocationItemFromMainNav();
        locations.chooseLocationFromLocationPage(locationName);
        massageServicePage.clickMassageService();
        chooseServices.chooseServiceAsMember(serviceName, duration, Users.MEMBER, false);
        String therapistName = prefferedDateTime.chooseTherapistAndDateTime("Any Employee", date, "04:00");
        paymentInformation.fillPaymentInformationForMember();
        confirmation.checkingSuccessBooking(locationName, serviceName, therapistName, duration, date);
    }

    @Test()
    public void testBookingAsGuestWithInvalidCard() throws InterruptedException {
        String locationName = "Cherry";
        String serviceName = "Teen Facial Clarity";
        String duration = "1 hour";
        String date = "Sep 21";
        home.open();
        facialServicePage.clickFacialService();
        createAccountPage.chooseLocation(locationName);
        chooseServices.chooseServiceAsGuest(serviceName, duration, true);
        prefferedDateTime.chooseTherapistAndDateTime("Any Employee", date, "12:00");
        paymentInformation.fillPaymentInformation(Users.DWYANE, CreditCards.TEST_CARD, false);
        confirmation.checkingErrorBooking();
    }


    @Test()
    public void testSuccessEmailBooking() throws InterruptedException {
        googleMail.signIntoGoogleMail(Users.VLADYSLAV);
        googleMail.checkingEmailBookingWithRegistration();
    }


}
