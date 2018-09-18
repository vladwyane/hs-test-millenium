package pages;

import blocks.Header;
import blocks.LastDeals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import utils.ConfigProperties;

import java.util.List;

/**
 * Created by bigdrop on 9/18/2018.
 */
public class LastDealsPage extends BasePage {

    public LastDealsPage(WebDriver driver) {
        super(driver);
    }

    LastDeals lastDeals;
    Header header;

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("lastDeals.url"));
    }

    public List<HtmlElement> getPurchaseButList() {
        return purchaseButList;
    }

    @Name("ArrayList of buttons LMD purchase now")
    @FindBys( {@FindBy(xpath = "//div[(@class='last-deals')]//following-sibling::div[contains(@id, 'ember')]//a[contains(@class, 'btn')]")} )
    private List<HtmlElement> purchaseButList;

    public void chooseFirstLMDServiceFromAvailable() throws InterruptedException {
        lastDeals.moveRangeSliderFullWidth(driver);
        waitUntilTextInElementAppear(lastDeals, "waiting");
        lastDeals.getSubmitButton().click();
        purchaseButList.get(0).click();
    }

    public void clickSpaDealsItemFromMainNav() {
        waitUntilTextInElementAppear(header, "Waiting");
        header.clickMenuItem("Spa Deals");
    }
}
