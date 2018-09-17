package pages.booking;

import blocks.booking.ContactInformationForm;
import blocks.booking.PasswordForm;
import blocks.booking.PaymentInformationForm;
import data.CreditCards;
import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by bigdrop on 9/13/2018.
 */
public class PaymentInformation extends BasePage {

    public PaymentInformation(WebDriver driver) {
        super(driver);
    }

    private ContactInformationForm contactInformationForm;
    private PaymentInformationForm paymentInformationForm;
    private PasswordForm passwordForm;

    @Override
    public void open() {

    }

    @FindBy(xpath = "//label[@for='form-create-account-cancellation-policy']")
    private HtmlElement cancellationPolicyCheckBox;

    @FindBy(css= ".confirm-booking")
    private Button confirmBockingBut;


    public void fillPaymentInformation(Users users, CreditCards creditCards, boolean createAccount) {
        fillContactInformation(users);
        fillCreditCardInfo(users, creditCards);
        if(createAccount == true)
            fillPasswordField(users);
        cancellationPolicyCheckBox.click();
        confirmBockingBut.click();
    }

    public void fillPaymentInformationForMember() throws InterruptedException {
        scrollToElement(cancellationPolicyCheckBox);
        contactInformationForm.getPrivatePolicyCheckBox().click();
        cancellationPolicyCheckBox.click();
        confirmBockingBut.click();
    }

    public PaymentInformation fillContactInformation(Users users) {
        type(contactInformationForm.getUserFirstName(), users.getFirstName());
        type(contactInformationForm.getUserLastName(), users.getLastName());
        type(contactInformationForm.getUserEmail(), users.getEmail());
        type(contactInformationForm.getUserPhone(), users.getPhone());
        contactInformationForm.getPrivatePolicyCheckBox().click();
        return this;
    }

    public PaymentInformation fillCreditCardInfo(Users users, CreditCards creditCards) {
        type(paymentInformationForm.getCardNameField(), creditCards.getCardName());
        type(paymentInformationForm.getCardNumberField(), creditCards.getCardNumber());
        type(paymentInformationForm.getCardCVVField(), creditCards.getCardCVV());
        type(paymentInformationForm.getZipCodeField(), users.getZipCode());
        paymentInformationForm.chooseMonth(creditCards.getCardMonth());
        paymentInformationForm.chooseYear(creditCards.getCardYear());
        return this;
    }

    public PaymentInformation fillPasswordField(Users users) {
        type(passwordForm.getPasswordField(), users.getNewPassword());
        type(passwordForm.getConfirmPassField(), users.getConfPassword());
        return this;
    }
}
