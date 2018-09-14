import data.CreditCards;
import data.Users;
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
public class BookingTest extends TestBase {

    private Home home;
    private CreateAccountPage createAccountPage;
    private GoogleMail googleMail;
    private MassageServicePage massageServicePage;
    private ChooseServices chooseServices;
    private PrefferedDateTime prefferedDateTime;
    private PaymentInformation paymentInformation;
    private Confirmation confirmation;

    @BeforeMethod
    public void initPageObjects() {
        home = new Home(app.getDriver());
        createAccountPage = new CreateAccountPage(app.getDriver());
        googleMail = new GoogleMail(app.getDriver());
        massageServicePage = new MassageServicePage(app.getDriver());
        chooseServices = new ChooseServices(app.getDriver());
        prefferedDateTime = new PrefferedDateTime(app.getDriver());
        paymentInformation = new PaymentInformation(app.getDriver());
        confirmation = new Confirmation(app.getDriver());
    }

    @Test(priority = 7)
    public void testBookingAsGuest() throws InterruptedException {
        String locationName = "Cherry";
        String serviceName = "Massage";
        String duration = "1 hour";
        String date = "Sep 15";
        home.open();
        massageServicePage.clickMassageService();
        createAccountPage.chooseLocation(locationName);
        chooseServices.chooseServiceAsGuest(serviceName, duration);
        String therapistName = prefferedDateTime.chooseTherapistAndDateTime("Any Employee", date, "12:00");
        paymentInformation.fillPaymentInformation(Users.LEBRON, CreditCards.VISA_STRIPE);
        confirmation.checkingSuccessBooking(locationName, serviceName, therapistName, duration, date);
    }

    @Test(priority = 8)
    public void testSuccessEmailBooking() throws InterruptedException {
        googleMail.signIntoGoogleMail(Users.VLADYSLAV);
        googleMail.checkingEmailBooking();
    }
}
