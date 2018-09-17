package pages.booking;

import blocks.booking.BookingDetail;
import blocks.booking.SuccessMessageBlock;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

/**
 * Created by bigdrop on 9/14/2018.
 */
public class Confirmation extends BasePage {

    public Confirmation(WebDriver driver) {
        super(driver);
    }

    private SuccessMessageBlock successMessageBlock;
    private BookingDetail bookingDetail;


    @Override
    public void open() {

    }

    public void checkingSuccessBooking(String location, String service, String therapist, String duration, String date) {
        waitUntilElementAppeared(successMessageBlock);
        softAssert.assertEquals(successMessageBlock.getSuccessHeading().getText(), "CONGRATULATIONS!");
        softAssert.assertTrue(bookingDetail.containsLocation(location), "Location " + location + " not found");
        softAssert.assertTrue(bookingDetail.containsService(service), "Service " + service + " not found");
        softAssert.assertTrue(bookingDetail.containsTherapist(therapist), "Therapist " + therapist + " not found");
        softAssert.assertTrue(bookingDetail.containsDuration(duration), "Duration " + duration + " not found");
        softAssert.assertTrue(bookingDetail.containsDate(date), "Date " + date + " not found");
        softAssert.assertAll();
    }
}
