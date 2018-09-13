package pages.booking;

import blocks.CreateAccountForm;
import blocks.booking.BookingInformationForm;
import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CreateAccountPage;

/**
 * Created by bigdrop on 9/13/2018.
 */
public class PaymentInformation extends BasePage {

    public PaymentInformation(WebDriver driver) {
        super(driver);
    }

    private BookingInformationForm bookingInformationForm;

    @Override
    public void open() {

    }

    public void fillRegistrationFields(Users users) {
        type(bookingInformationForm.getUserFirstName(), users.getFirstName());
        type(bookingInformationForm.getUserLastName(), users.getLastName());
        type(bookingInformationForm.getUserEmail(), users.getEmail());
        type(bookingInformationForm.getUserPhone(), users.getPhone());
        bookingInformationForm.getPrivatePolicyCheckBox().click();
    }
}
