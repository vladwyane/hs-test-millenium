package pages.account;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 9/10/2018.
 */
public class Appointments extends BasePage {

    public Appointments(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("accountAppointments.url"));
    }
}
