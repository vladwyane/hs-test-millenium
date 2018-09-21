package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import utils.ConfigProperties;

import java.util.List;

/**
 * Created by bigdrop on 9/21/2018.
 */
public class MillenniumPOS extends BasePage {

    public MillenniumPOS(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("adminMillenniumPOS.url"));
    }

    @FindBy(css = "button.confirm")
    private HtmlElement confirmPopupBut;

    @FindBy(css = "button.cancel")
    private HtmlElement cancelPopupBut;

    @Name("ArrayList of queue buttons")
    @FindBys( {@FindBy(css = "button.force-getter")} )
    private List<HtmlElement> listCreateQueueBut;

    private void clickCreateQueueBut(String queueButName) {
        for (int i = 0; i < listCreateQueueBut.size(); i++) {
            if(queueButName.equals(listCreateQueueBut.get(i).getAttribute("data-type"))) {
                listCreateQueueBut.get(i).click();
                return;
            }
        }
    }

    public void makeQueueToPOS(String dataTypeQueue) {
        clickCreateQueueBut(dataTypeQueue);
        waitUntilTextInElementAppear(confirmPopupBut, "waiting");
        confirmPopupBut.click();
        waitUntilElementWillBeClickable(confirmPopupBut);
        confirmPopupBut.click();
    }

}
