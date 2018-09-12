package pages;

import blocks.CreateAccountForm;
import blocks.Header;
import blocks.popUps.LocationPopup;
import data.Users;
import data.UsersData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.account.Dashboard;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 8/31/2018.
 */
public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    private CreateAccountForm createAccountForm;
    private Header header;
    private LocationPopup locationPopup;

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("signUp.url"));
    }

    @FindBy(id = "modal-header-id")
    private HtmlElement titleInfoPopup;

    public void fillRegistrationFieldsFromJson (UsersData users) {
        type(createAccountForm.getFirstNameField(), users.getFirstName());
        type(createAccountForm.getLastNameField(), users.getLastName());
        type(createAccountForm.getPasswordField(), users.getPassword());
        type(createAccountForm.getConfPasswordField(), users.getConfPassword());
        type(createAccountForm.getEmailField(), users.getEmail());
        type(createAccountForm.getPhoneField(), users.getPhone());
        fillLocationField(users.getLocation());
    }

    public void fillRegistrationFields(Users users) {
        type(createAccountForm.getFirstNameField(), users.getFirstName());
        type(createAccountForm.getLastNameField(), users.getLastName());
        type(createAccountForm.getPasswordField(), users.getNewPassword());
        type(createAccountForm.getConfPasswordField(), users.getConfPassword());
        type(createAccountForm.getEmailField(), users.getEmail());
        type(createAccountForm.getPhoneField(), users.getPhone());
        fillLocationField(users.getLocation());
    }

    public void fillLocationField(String nameLocation) {
        createAccountForm.getLocationField().click();
        chooseLocation(nameLocation);
    }

    public void chooseLocation(String nameLocation) {
        locationPopup.clickFindLocationLink();
        for (int i = 0; i < locationPopup.getTitlesLocationList().size(); i++) {
            if(isElementInvisible(locationPopup.getTitlesLocationList().get(i)) == true)
                locationPopup.clickRightArrowOfCarousel();
            if(locationPopup.getTitlesLocationList().get(i).getText().contains(nameLocation.toUpperCase())) {
                locationPopup.getSelectButLocationList().get(i).click();
                return;
            }
        }
        locationPopup.getSelectButLocationList().get(locationPopup.getSelectButLocationList().size() - 1).click();
    }

    public Dashboard registrationFromJson (UsersData users) {
        openRegistrationPage();
        fillRegistrationFieldsFromJson(users);
        createAccountForm.clickCreateAccBut();
        return new Dashboard(driver);
    }

    public Dashboard registration (Users users) {
        fillRegistrationFields(users);
        createAccountForm.clickCreateAccBut();
        return new Dashboard(driver);
    }

    public CreateAccountPage clickCreateAccButWithEmptyFields() {
        createAccountForm.getFirstNameField().clear();
        createAccountForm.getLastNameField().clear();
        createAccountForm.getPasswordField().clear();
        createAccountForm.getConfPasswordField().clear();
        createAccountForm.getEmailField().clear();
        createAccountForm.getPhoneField().clear();
        createAccountForm.clickCreateAccBut();
        return this;
    }

    public CreateAccountPage openRegistrationPage() {
        header.clickSignUpLink();
        return new CreateAccountPage(driver);
    }

    public CreateAccountPage checkingErrorNotesAllFieldsAreBlank() {
        String errorNoteFieldsBlank = "This field can't be blank";
        String errorColor = "rgba(235, 0, 0, 1)";
        waitUntilTextInElementAppear(createAccountForm.getPhoneFieldNote(), errorColor);
        softAssert.assertEquals(createAccountForm.getFirstNameFieldNote().getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(createAccountForm.getFirstNameFieldNote().getCssValue("color"), errorColor);

        softAssert.assertEquals(createAccountForm.getLastNameFieldNote().getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(createAccountForm.getLastNameFieldNote().getCssValue("color"), errorColor);

        softAssert.assertEquals(createAccountForm.getPasswordFieldNote().getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(createAccountForm.getPasswordFieldNote().getCssValue("color"), errorColor);

        softAssert.assertEquals(createAccountForm.getEmailFieldNote().getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(createAccountForm.getEmailFieldNote().getCssValue("color"), errorColor);

        softAssert.assertEquals(createAccountForm.getPasswordFieldNote().getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(createAccountForm.getPasswordFieldNote().getCssValue("color"), errorColor);

        softAssert.assertAll();
        return this;
    }

    public CreateAccountPage checkingErrorNoteNotMatchPassword() {
        String errorNoteNotMatchPassword = "This field doesn't match password";
        String errorColor = "rgba(235, 0, 0, 1)";
        softAssert.assertEquals(createAccountForm.getConfPasswordFieldNote().getText(), errorNoteNotMatchPassword);
        softAssert.assertEquals(createAccountForm.getConfPasswordFieldNote().getCssValue("color"), errorColor);
        softAssert.assertAll();
        return this;
    }

    public CreateAccountPage checkingErrorNoteExistEmail(Users users) {
        String errorNotExistEmail = "Email \"" + users.getEmail() + "\" has already been taken.";
        String errorColor = "rgba(235, 0, 0, 1)";
        softAssert.assertEquals(createAccountForm.getEmailFieldNote().getText(), errorNotExistEmail);
        softAssert.assertEquals(createAccountForm.getEmailFieldNote().getCssValue("color"), errorColor);
        softAssert.assertAll();
        return this;
    }


    public void checkingSuccessOfRegistration() {
        if(isElementPresent(titleInfoPopup) == true) {
            softAssert.assertEquals(titleInfoPopup.getText(), "Confirm email");
            softAssert.assertEquals(driver.getCurrentUrl(), ConfigProperties.getProperty("signIn.url"));
        } else {
            softAssert.assertTrue(isElementPresent(titleInfoPopup), "Element is not found");
            softAssert.assertEquals(driver.getCurrentUrl(), ConfigProperties.getProperty("signIn.url"));
        }
        softAssert.assertAll();
    }
}
