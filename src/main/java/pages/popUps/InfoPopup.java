package pages.popUps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.SignIn;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 8/31/2018.
 */
public class InfoPopup extends BasePage {

    public InfoPopup(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(id = "modal-header-id")
    private WebElement titleModal;

    public void checkingSuccessOfRegistration() {
        if(isElementPresent(titleModal) == true) {
            softAssert.assertEquals(titleModal.getText(), "Confirm email");
            softAssert.assertEquals(driver.getCurrentUrl(), ConfigProperties.getProperty("signIn.url"));
        } else {
            softAssert.assertTrue(isElementPresent(titleModal), "Element is not found");
            softAssert.assertEquals(driver.getCurrentUrl(), ConfigProperties.getProperty("signIn.url"));
        }
        softAssert.assertAll();
        driver.navigate().refresh();
    }
}
