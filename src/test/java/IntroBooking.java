import data.*;
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
        home.open();
        massageServicePage.clickMassageService();
        createAccountPage.chooseLocation(LocationsData.CHERRY_HILL);
        chooseServices.chooseServiceAsFirstVisitor(ServicesData.INTROHS50);
        String therapistName = prefferedDateTime.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.SEPTEMBER30_10AM);
        paymentInformation.fillPaymentInformation(Users.ALLEN, CreditCards.VISA_STRIPE, false);
        confirmation.checkingSuccessBooking(LocationsData.CHERRY_HILL, ServicesData.INTROHS50, therapistName, DateTime.SEPTEMBER30_10AM);
    }

    @Test()
    public void testBookingAsFistTimeVisitorWithExistEmail() throws InterruptedException {
        home.open();
        massageServicePage.clickMassageService();
        createAccountPage.chooseLocation(LocationsData.CHERRY_HILL);
        chooseServices.chooseServiceAsFirstVisitor(ServicesData.INTROHS50);
        prefferedDateTime.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.SEPTEMBER21_12PM);
        paymentInformation.fillPaymentInformation(Users.ALLEN, CreditCards.VISA_STRIPE, false);
        confirmation.checkingErrorBooking();
    }


}
