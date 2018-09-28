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

    @FindBy(xpath = "//a[contains(@href, 'reset-password')]")
    private Link resetPasswordLink;

    @FindBys( {@FindBy(css = ".bog")} )
    public List<HtmlElement> listTitleLetters;

    @FindBy(xpath = "//a[contains(@aria-label, 'Google Account')]")
    private HtmlElement accountAva;

    @FindBy(xpath = "//a[contains(text(), 'Sign out')]")
    private HtmlElement signOutBut;

    public String signIntoGoogleMail(Users users) throws InterruptedException {
        open();
        waitUntilElementAppeared(nextIndButton);
        type(loginField, users.getEmail());
        nextIndButton.click();
        waitUntilElementAppeared(nextPassButton);
        type(passwordField, users.getNewPassword());
        nextPassButton.click();
        Thread.sleep(5000);
        String titleLetter = listTitleLetters.get(0).getText();

        return titleLetter;
    }

    public String returnResetPassLink() {
        listTitleLetters.get(0).click();
        waitUntilTextInElementAppear(listTitleLetters.get(0), "waiting");
        return resetPasswordLink.getReference();

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

    public void checkingEmailResetPassword() {
        softAssert.assertEquals(listTitleLetters.get(0).getText(), "Password reset for Hand&Stone");
        softAssert.assertAll();
    }

    public void accountLogout() {
        if (isElementPresent(accountAva) == true) {
            accountAva.click();
            waitUntilElementWillBeClickable(signOutBut);
            signOutBut.click();
        }
    }
}
