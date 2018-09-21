package pages;

import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import utils.ConfigProperties;

import java.util.List;

/**
 * Created by bigdrop on 9/12/2018.
 */
public class GoogleMail extends BasePage {

    public GoogleMail(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("googleMail.url"));
    }

    @FindBy(name = "identifier")
    private TextInput loginField;

    @FindBy(name = "password")
    private TextInput passwordField;

    @FindBy(id = "identifierNext")
    private HtmlElement nextIndButton;

    @FindBy(id = "passwordNext")
    private HtmlElement nextPassButton;

    @FindBys( {@FindBy(css = ".bog")} )
    public List<HtmlElement> listTitleLetters;

    public void signIntoGoogleMail(Users users) {
        open();
        waitUntilElementAppeared(nextIndButton);
        type(loginField, users.getEmail());
        nextIndButton.click();
        waitUntilElementAppeared(nextPassButton);
        type(passwordField, users.getNewPassword());
        nextPassButton.click();
        waitUntilElementAppeared(listTitleLetters.get(0));
    }

    public void checkingEmailChangePass() {
        softAssert.assertEquals(listTitleLetters.get(0).getText(), "Change Password");
        softAssert.assertAll();
    }

    public void checkingEmailRegistration() {
        softAssert.assertEquals(listTitleLetters.get(0).getText(), "Hand&Stone");
        softAssert.assertAll();
    }

    public void checkingEmailBooking() {
        softAssert.assertEquals(listTitleLetters.get(0).getText(), "Hand&Stone Booking");
        softAssert.assertAll();
    }

    public void checkingEmailBookingWithRegistration() {
        softAssert.assertEquals(listTitleLetters.get(0).getText(), "Hand&Stone");
        softAssert.assertEquals(listTitleLetters.get(2).getText(), "Hand&Stone Booking");
        softAssert.assertAll();
    }
}
