package blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

/**
 * Created by bigdrop on 9/18/2018.
 */
@Block(@FindBy(className = "last-deals"))
public class LastDeals extends HtmlElement {

    public HtmlElement getNothingFoundSection() {
        return nothingFoundSection;
    }

    @FindBy(css = ".nothing-found")
    private HtmlElement nothingFoundSection;


    public WebElement getSliderRangeFirstBullet() {
        return sliderRangeFirstBullet;
    }

    @FindBy(xpath = "(//span[contains(@class, 'ui-slider-handle')])[1]")
    private WebElement sliderRangeFirstBullet;

    public WebElement getSliderRangeLastBullet() {
        return sliderRangeLastBullet;
    }

    @FindBy(xpath = "(//span[contains(@class, 'ui-slider-handle')])[2]")
    private WebElement sliderRangeLastBullet;

    public Button getSubmitButton() {
        return submitButton;
    }

    @FindBy(xpath = "//button[contains(text(), 'submit')]")
    private Button submitButton;

    public List<HtmlElement> getPurchaseButList() {
        return purchaseButList;
    }

    @Name("ArrayList of buttons LMD purchase now")
    @FindBys( {@FindBy(xpath = "//a[contains(@aria-describedby, 'spa_deal')]")} )
    private List<HtmlElement> purchaseButList;

    public void moveRangeSliderFullWidth(WebDriver driver) {
        Actions move = new Actions(driver);
        Action actionFirstBull = move.dragAndDropBy(sliderRangeFirstBullet, -500, 0).build();
        actionFirstBull.perform();
        Action actionLastBull = move.dragAndDropBy(sliderRangeLastBullet, 500, 0).build();
        actionLastBull.perform();
    }

    public void moveRangeSliderNullWidth(WebDriver driver) {
        Actions move = new Actions(driver);
        Action actionFirstBull = move.dragAndDropBy(sliderRangeFirstBullet, -500, 0).build();
        actionFirstBull.perform();
        Action actionLastBull = move.dragAndDropBy(sliderRangeLastBullet, -500, 0).build();
        actionLastBull.perform();
    }
}
