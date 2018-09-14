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
        softAssert.assertTrue(bookingDetail.containsLocation(location), "Location not found");
        softAssert.assertTrue(bookingDetail.containsService(service), "Service not found");
        softAssert.assertTrue(bookingDetail.containsTherapist(therapist), "Therapist not found");
        softAssert.assertTrue(bookingDetail.containsDuration(duration), "Duration not found");
        softAssert.assertTrue(bookingDetail.containsDate(date), "Date not found");
        softAssert.assertAll();
    }
}
