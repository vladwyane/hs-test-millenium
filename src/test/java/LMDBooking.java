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
    public void testLMDBookingNothingFound() throws InterruptedException {
        String locationName = "Cherry Hill";
        home.open();
        locations.clickLocationItemFromMainNav();
        locations.chooseLocationFromLocationPage(locationName);
        home.open();
    }

    @Test()
    public void testLMDBookingFromHomePage() throws InterruptedException {
        String locationName = "Cherry Hill";
        locations.open();
        locations.chooseLocationFromLocationPage(locationName);
        home.open();
        home.chooseFirstLMDServiceFromAvailable();
        paymentInformation.fillPaymentInformation(Users.LEBRON, CreditCards.VISA_STRIPE, false);
        confirmation.checkingSuccessLMDBooking();
    }

    @Test()
    public void testLMDBookingFromSpaDealsPage() throws InterruptedException {
        String locationName = "Cherry";
        home.open();
        lastDealsPage.clickSpaDealsItemFromMainNav();
        createAccountPage.chooseLocation(locationName);
        lastDealsPage.chooseFirstLMDServiceFromAvailable();
        paymentInformation.fillPaymentInformation(Users.LEBRON, CreditCards.VISA_STRIPE, false);
        confirmation.checkingSuccessLMDBooking();
    }

    @Test()
    public void testLMDBookingFromLocationPage() throws InterruptedException {
        String locationName = "Cherry Hill";
        locations.open();
        locations.moveToLocationDetail(locationName);
        home.chooseFirstLMDServiceFromAvailable();
        paymentInformation.fillPaymentInformation(Users.LEBRON, CreditCards.VISA_STRIPE, false);
        confirmation.checkingSuccessLMDBooking();
    }
}
