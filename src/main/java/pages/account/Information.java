package pages.account;

import blocks.account.AccountContactInfoForm;
import blocks.account.ChangePasswordForm;
import data.Users;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import utils.ConfigProperties;

import java.util.List;

/**
 * Created by bigdrop on 9/10/2018.
 */
public class Information extends BasePage {

    public Information(WebDriver driver) {
        super(driver);
    }

    AccountContactInfoForm accountContactInfoForm;
    ChangePasswordForm changePasswordForm;

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("accountInformation.url"));
    }

    @FindBy(id = "modal-header-id")
    private HtmlElement titleInfoPopup;

    @Name("ArrayList of state")
    @FindBys( {@FindBy(css = ".jcf-select-drop li")} )
    public List<HtmlElement> listState;

    public void checkAccountContactInfo(Users users) {
        softAssert.assertEquals(accountContactInfoForm.getUserFirstName().getEnteredText(), (users.getFirstName()));
        softAssert.assertEquals(accountContactInfoForm.getUserLastName().getEnteredText(), (users.getLastName()));
        softAssert.assertEquals(accountContactInfoForm.getUserEmail().getEnteredText(), (users.getEmail()));
        softAssert.assertEquals(accountContactInfoForm.getUserPhone().getEnteredText(), splitPhoneNumToNewFormat(users));
        softAssert.assertAll();
    }

    public String splitPhoneNumToNewFormat(Users users) {
        String phoneNum = users.getPhone();
        char[] strToArray = phoneNum.toCharArray();
        String newPhoneNum = "";
        for (int i = 0; i < strToArray.length; i++) {
            if (i == 2)
                newPhoneNum += Character.toString(strToArray[i]) + "-";
            else if(i == 5)
                newPhoneNum += Character.toString(strToArray[i]) + "-";
            else newPhoneNum += Character.toString(strToArray[i]);
        }
        return newPhoneNum;
    }

    public Information updateContactInfo(Users users) {
        type(accountContactInfoForm.getUserFirstName(), users.getFirstName());
        type(accountContactInfoForm.getUserLastName(), users.getLastName());
        type(accountContactInfoForm.getUserAddress(), users.getAddress());
        type(accountContactInfoForm.getUserCity(), users.getCity());
        type(accountContactInfoForm.getUserZipCode(), users.getZipCode());
        chooseState(users.getState());
        accountContactInfoForm.getSaveChangesBut().click();
        return this;
    }

    public void chooseState(String stateName) throws StaleElementReferenceException {
        accountContactInfoForm.getStateSelect().click();
        try {
            for(WebElement element : listState) {
                if(element.getText().equals(stateName) || element.equals(listState.get(listState.size() - 1)))
                    element.click();
            }
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){}
    }

    public void checkingSuccessPopup() {
        softAssert.assertTrue(waitUntilElementAppeared(titleInfoPopup));
        softAssert.assertEquals(titleInfoPopup.getText(), "Success!");
        softAssert.assertAll();
    }

    public Information changePassword(Users users) {
        type(changePasswordForm.getCurrentPassField(), users.getPassword());
        type(changePasswordForm.getNewPassField(), users.getNewPassword());
        type(changePasswordForm.getConfirmPassField(), users.getConfPassword());
        changePasswordForm.getChangePassBut().click();
        return this;
    }
}
