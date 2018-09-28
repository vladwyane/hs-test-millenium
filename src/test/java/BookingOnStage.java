import data.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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

import java.io.IOException;

/**
 * Created by bigdrop on 9/28/2018.
 */
public class BookingOnStage extends TestBase {

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

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of booking as guest")
    public void testFirstPopupIsPresent() throws InterruptedException {
        String labelPopup = home.openStage();
        home.checkingFirstVisitPopup(labelPopup);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of booking as guest")
    public void testBookingAsGuest() throws InterruptedException, IOException {
        home.openStage();
        massageServicePage.clickMassageService();
        createAccountPage.chooseLocation(LocationsData.PEORIA_AZ);
        chooseServices.chooseServiceAsGuest(ServicesData.NSM80, false);
        String therapistName = prefferedDateTime.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.OCTOBER25_3PM);
        paymentInformation.fillPaymentInformation(Users.VLADYSLAV_PROD, CreditCards.VISA_STRIPE, false);
        confirmation.checkingSuccessBooking(LocationsData.PEORIA_AZ, ServicesData.NSM80, therapistName, DateTime.OCTOBER25_3PM);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Negative test of booking with invalid card")
    public void testBookingAsGuestWithInvalidCard() throws InterruptedException {
        home.openStage();
        massageServicePage.clickMassageService();
        createAccountPage.chooseLocation(LocationsData.EDGEWATER_NJ);
        chooseServices.chooseServiceAsGuest(ServicesData.NSM80, false);
        prefferedDateTime.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.OCTOBER25_3PM);
        paymentInformation.fillPaymentInformation(Users.VLADYSLAV_PROD, CreditCards.TEST_CARD, false);
        confirmation.checkingErrorBooking();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Story("Positive test of booking as member")
    public void testBookingAsRegistered() throws InterruptedException, IOException {
        home.openStage();
        locations.clickLocationItemFromMainNav();
        locations.chooseLocationFromLocationPage(LocationsData.NAPERVILLE_IL);
        facialServicePage.clickFacialService();
        chooseServices.chooseServiceAsMember(ServicesData.NMF50, Users.VLADYSLAV_PROD, false);
        String therapistName = prefferedDateTime.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.OCTOBER26_11AM);
        paymentInformation.fillPaymentInformation(Users.VLADYSLAV_PROD, CreditCards.VISA_STRIPE, false);
        confirmation.checkingSuccessBooking(LocationsData.NAPERVILLE_IL, ServicesData.NMF50, therapistName, DateTime.OCTOBER26_11AM);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.MINOR)
    @Story("Test of email with success booking")
    public void testSuccessEmailBooking() throws InterruptedException {
        googleMail.signIntoGoogleMail(Users.VLADYSLAV);
        googleMail.checkingEmailBooking();
    }
}
