package pages;

import blocks.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import utils.ConfigProperties;

import java.util.List;

/**
 * Created by bigdrop on 9/12/2018.
 */
public class MassageServicePage extends BasePage {

    Header header;

    public MassageServicePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("massageService.url"));
    }

    @FindBy(xpath = "//a[@aria-describedby = 'class-massage']")
    private Button bookMassageBut;

    public void clickMassageService() {
        waitUntilTextInElementAppear(header, "Massage");
        header.clickMenuItem("Massage");
        bookMassageBut.click();
    }
}
