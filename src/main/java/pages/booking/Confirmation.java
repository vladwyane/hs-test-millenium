package pages.booking;

import blocks.booking.BookingDetail;
import blocks.booking.SuccessMessageBlock;
import data.DateTime;
import data.LocationsData;
import data.ServicesData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by bigdrop on 9/14/2018.
 */
public class Confirmation extends BasePage {

    public Confirmation(WebDriver driver) {
        super(driver);
    }

    private SuccessMessageBlock successMessageBlock;
    private BookingDetail bookingDetail;

    @FindBy(xpath = "//div[@data-id='modalBookingErrors']//h3")
    private HtmlElement titleInfoPopup;

    @FindBy(xpath = "//div[@data-id='modalBookingErrors']//div[contains(@id, 'booking-error-described')]")
    private HtmlElement errorDescribe;

    @Override
    public void open() {

    }

    public void checkingSuccessBooking(LocationsData locationsData, ServicesData servicesData, String therapist, DateTime dateTime) {
        waitUntilElementAppeared(successMessageBlock);
        softAssert.assertEquals(successMessageBlock.getSuccessHeading().getText(), "CONGRATULATIONS!");
        softAssert.assertEquals(successMessageBlock.getAddToCalendarBut().getText(), "ADD TO CALENDAR");
        softAssert.assertEquals(successMessageBlock.getBookAnotherAppBut().getText(), "BOOK ANOTHER APPOINTMENT");
        softAssert.assertEquals(successMessageBlock.getDownloadFormBut().getText(), "DOWNLOAD INTAKE FORM");
        softAssert.assertTrue(bookingDetail.containsLocation(locationsData.getLocationName()), "Location " + locationsData.getLocationName() + " not found");
        softAssert.assertTrue(bookingDetail.containsService(servicesData.getServiceName()), "Service " + servicesData.getServiceName() + " not found");
        softAssert.assertTrue(bookingDetail.containsTherapist(therapist), "Therapist " + therapist + " not found");
        softAssert.assertTrue(bookingDetail.containsDuration(servicesData.getDuration()), "Duration " + servicesData.getDuration() + " not found");
        softAssert.assertTrue(bookingDetail.containsDate(dateTime.getDate()), "Date " + dateTime.getDate() + " not found");
        softAssert.assertAll();
    }

    public void checkingErrorBooking() {
        waitUntilElementAppeared(titleInfoPopup);
        softAssert.assertEquals(titleInfoPopup.getText(), "Errors");
        softAssert.assertTrue(isElementPresent(errorDescribe), "Error describe text not found");
        softAssert.assertAll();
    }

    public void checkingSuccessLMDBooking() {
        waitUntilElementAppeared(successMessageBlock);
        softAssert.assertEquals(successMessageBlock.getSuccessHeading().getText(), "CONGRATULATIONS!");
        softAssert.assertEquals(successMessageBlock.getAddToCalendarBut().getText(), "ADD TO CALENDAR");
        softAssert.assertEquals(successMessageBlock.getBookAnotherAppBut().getText(), "BOOK ANOTHER APPOINTMENT");
        softAssert.assertEquals(successMessageBlock.getDownloadFormBut().getText(), "DOWNLOAD INTAKE FORM");
        softAssert.assertTrue(isElementPresent(successMessageBlock.getBarCode()), "Bar code not found");
        softAssert.assertAll();
    }
}
