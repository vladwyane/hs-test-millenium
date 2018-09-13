package pages.booking;

import blocks.booking.AddAromaServices;
import blocks.booking.AuthorizationBlock;
import blocks.booking.Duration;
import blocks.booking.Services;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by bigdrop on 9/12/2018.
 */
public class ChooseServices extends BasePage {

    public ChooseServices(WebDriver driver) {
        super(driver);
    }

    Services services;
    AuthorizationBlock authorizationBlock;
    Duration duration;
    AddAromaServices addAromaServices;

    @Override
    public void open() {

    }

    @FindBy(css= "a.continue")
    private Button continueBut;

    public void chooseService(String serviceName, String timeDuration) throws InterruptedException {
        authorizationBlock.getContinueAsGuestBut().click();
        services.chooseService(serviceName);
        scrollToElement(duration);
        duration.chooseTimeDuration(timeDuration);
        scrollToElement(addAromaServices);
        addAromaServices.chooseAddAromaService();
        continueBut.click();
    }
}
