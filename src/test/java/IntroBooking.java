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
 * Created by bigdrop on 9/18/2018.
 */
public class IntroBooking extends TestBase {

    private Home home;
    private CreateAccountPage createAccountPage;
    private GoogleMail googleMail;
    private FacialServicePage facialServicePage;
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
        facialServicePage = new FacialServicePage(app.getDriver());
        massageServicePage = new MassageServicePage(app.getDriver());
        chooseServices = new ChooseServices(app.getDriver());
        prefferedDateTime = new PrefferedDateTime(app.getDriver());
        paymentInformation = new PaymentInformation(app.getDriver());
        confirmation = new Confirmation(app.getDriver());
    }

    @AfterMethod
    public void clearAllCookies() {
        app.delleteAllCookies();
    }

    @Test()
    public void testBookingAsFistTimeVisitor() throws InterruptedException {
        String locationName = "Cherry";
        String serviceName = "Hot Stone Massage";
        String duration = "1 hour";
        String date = "Sep 19";
        home.open();
        massageServicePage.clickMassageService();
        createAccountPage.chooseLocation(locationName);
        chooseServices.chooseServiceAsFirstVisitor(serviceName);
        String therapistName = prefferedDateTime.chooseTherapistAndDateTime("Any Employee", date, "03:00");
        paymentInformation.fillPaymentInformation(Users.ALLEN, CreditCards.VISA_STRIPE, false);
        confirmation.checkingSuccessBooking(locationName, serviceName, therapistName, duration, date);
    }

    @Test()
    public void testBookingAsFistTimeVisitorWithExistEmail() throws InterruptedException {
        String locationName = "Cherry";
        String serviceName = "Hot Stone Massage";
        String date = "Sep 19";
        home.open();
        massageServicePage.clickMassageService();
        createAccountPage.chooseLocation(locationName);
        chooseServices.chooseServiceAsFirstVisitor(serviceName);
        prefferedDateTime.chooseTherapistAndDateTime("Any Employee", date, "03:00");
        paymentInformation.fillPaymentInformation(Users.ALLEN, CreditCards.VISA_STRIPE, false);
        confirmation.checkingErrorBooking();
    }


}
