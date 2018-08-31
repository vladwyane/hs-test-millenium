package pages;

import org.openqa.selenium.WebDriver;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 8/31/2018.
 */
public class Home extends BasePage{

    public Home(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("home.url"));
    }
}
