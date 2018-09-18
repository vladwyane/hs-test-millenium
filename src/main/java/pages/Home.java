package pages;

import blocks.LastDeals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 8/31/2018.
 */
public class Home extends BasePage{

    public Home(WebDriver driver) {
        super(driver);
    }

    LastDeals lastDeals;

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("home.url"));
    }


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
}
