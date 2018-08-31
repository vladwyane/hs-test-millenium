package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * Created by bigdrop on 8/31/2018.
 */
public abstract class BasePage {

    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void open();

    @FindBy(xpath = "//a[@href='/sign-up']")
    protected WebElement signUpLink;

    @FindBy(xpath = "//div[@aria-label='Locations']//a[contains(text(), 'Find locations')]")
    protected WebElement findLocationLink;

    @FindBy(css = ".location-popup-loader .icon-arrow_right")
    protected WebElement rightArrowOfCarousel;

    @FindBys( {@FindBy(css = ".location-popup-loader li h6")} )
    private List<WebElement> titlesLocationList;

    @FindBys( {@FindBy(xpath = "//div[contains (@class, 'location-popup-loader')]//li//a[contains (@class, 'btn')]")} )
    private List<WebElement> selectButLocationList;

    protected void type(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 0);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void chooseLocation(String nameLocation) {
        for (int i = 0; i < titlesLocationList.size(); i++) {
            if(isElementInvisible(titlesLocationList.get(i)) == true)
                rightArrowOfCarousel.click();
            String tit = titlesLocationList.get(i).getText();
            if(titlesLocationList.get(i).getText().contains(nameLocation.toUpperCase())) {
                selectButLocationList.get(i).click();
                return;
            }
        }
        selectButLocationList.get(selectButLocationList.size() - 1).click();
    }
}
