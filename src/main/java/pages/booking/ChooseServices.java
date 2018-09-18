package pages.booking;

import blocks.booking.*;
import data.Users;
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
    IntroductoryPrices introductoryPrices;

    @Override
    public void open() {

    }

    @FindBy(css= "a.continue")
    private Button continueBut;

    public void chooseServiceAsGuest(String serviceName, String timeDuration, boolean addAromaService) throws InterruptedException {
        authorizationBlock.getContinueAsGuestBut().click();
        services.chooseService(serviceName);
        scrollToElement(duration);
        duration.chooseTimeDuration(timeDuration);
        scrollToElement(addAromaServices);
        if(addAromaService == true)
            addAromaServices.chooseAddAromaService();
        continueBut.click();
    }

    public void chooseServiceAsMember(String serviceName, String timeDuration, Users users, boolean addAromaService) throws InterruptedException {
        type(authorizationBlock.getEmailField(), users.getEmail());
        type(authorizationBlock.getPasswordField(), users.getNewPassword());
        authorizationBlock.getLoginBut().click();
        services.chooseService(serviceName);
        scrollToElement(duration);
        duration.chooseTimeDuration(timeDuration);
        scrollToElement(addAromaServices);
        if(addAromaService == true)
            addAromaServices.chooseAddAromaService();
        continueBut.click();
    }

    public void chooseServiceAsFirstVisitor(String serviceName) throws InterruptedException {
        authorizationBlock.getFirstVisitorBut().click();
        for (int i = 0; i < introductoryPrices.getListIntroTitles().size(); i++) {
            if(introductoryPrices.getListIntroTitles().get(i).getText().contains(serviceName.toUpperCase())) {
                introductoryPrices.getListIntroServiceBut().get(i).click();
                return;
            }
        }
        introductoryPrices.getListIntroServiceBut().get(0).click();
    }
}
