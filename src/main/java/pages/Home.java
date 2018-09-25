package pages;

import blocks.LastDeals;
import blocks.popUps.ResetPasswordPopup;
import data.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 8/31/2018.
 */
public class Home extends BasePage{

    public Home(WebDriver driver) {
        super(driver);
    }

    LastDeals lastDeals;
    ResetPasswordPopup resetPasswordPopup;

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("home.url"));
    }

    @FindBy(id = "modal-header-id")
    private HtmlElement titleInfoPopup;


    public void checkingNothingFoundSection() throws InterruptedException {
        lastDeals.moveRangeSliderNullWidth(driver);
        waitUntilTextInElementAppear(lastDeals, "waiting");
        lastDeals.getSubmitButton().click();
        softAssert.assertTrue(isElementPresent(lastDeals.getNothingFoundSection()), "Section not found");
        softAssert.assertAll();
    }

    public void chooseFirstLMDServiceFromAvailable() throws InterruptedException {
        lastDeals.moveRangeSliderFullWidth(driver);
        waitUntilTextInElementAppear(lastDeals, "waiting");
        lastDeals.getSubmitButton().click();
        lastDeals.getPurchaseButList().get(0).click();
    }

    public void resetNewPassword(Users users) throws InterruptedException {
        waitUntilTextInElementAppear(resetPasswordPopup, "waiting");
        type(resetPasswordPopup.getNewPasswordField(), users.getNewPassword());
        type(resetPasswordPopup.getNewPasswordRepeatField(), users.getNewPassword());
        resetPasswordPopup.clickResetPassBut();
    }

    public void checkingSuccessRessetPassword() {
        waitUntilTextInElementAppear(titleInfoPopup, "waiting");
        if(isElementPresent(titleInfoPopup) == true) {
            softAssert.assertEquals(titleInfoPopup.getText(), "Success!");
        } else {
            softAssert.assertTrue(isElementPresent(titleInfoPopup), "Element is not found");
        }
        softAssert.assertAll();
    }
}
