package pages;

import blocks.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import utils.ConfigProperties;

/**
 * Created by bigdrop on 9/17/2018.
 */
public class FacialServicePage extends BasePage{

    Header header;

    public FacialServicePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("facialService.url"));
    }

    @FindBy(xpath = "//a[@aria-describedby = 'class-facial']")
    private Button bookFacialBut;


    public void clickFacialService() {
        waitUntilTextInElementAppear(header, "Massage");
        header.clickMenuItem("Facials");
        bookFacialBut.click();
    }
}
