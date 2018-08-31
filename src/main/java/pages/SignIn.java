package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 8/31/2018.
 */
public class SignIn extends BasePage {

    public SignIn(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("signIn.url"));
    }

    @FindBy(id = "registration-block-first-name")
    private WebElement firstNameField;
}
