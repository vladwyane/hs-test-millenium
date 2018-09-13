package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.List;

/**
 * Created by bigdrop on 8/31/2018.
 */
public abstract class BasePage {

    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    public BasePage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
    }

    public abstract void open();

    protected void type(TextInput webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 0);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean waitUntilTextInElementAppear(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean waitUntilElementAppeared(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean waitUntilElementWillBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean scrollToElement(WebElement element) throws InterruptedException {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
