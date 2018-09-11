package blocks.popUps;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

@Block(@FindBy(className = "location-choose-popup"))
public class LocationPopup extends HtmlElement{

    @FindBy(xpath = "//div[@aria-label='Locations']//a[contains(text(), 'Find locations')]")
    private Link findLocationLink;

    public void clickFindLocationLink() {
        findLocationLink.click();
    }

    @FindBy(css = ".location-popup-loader .icon-arrow_right")
    protected Button rightArrowOfCarousel;

    public void clickRightArrowOfCarousel() {
        findLocationLink.click();
    }

    public List<HtmlElement> getTitlesLocationList() {
        return titlesLocationList;
    }

    @Name("ArrayList of locations titles")
    @FindBys( {@FindBy(css = ".location-popup-loader li h6")} )
    private List<HtmlElement> titlesLocationList;

    public List<Button> getSelectButLocationList() {
        return selectButLocationList;
    }

    @Name("ArrayList of locations buttons-select")
    @FindBys( {@FindBy(xpath = "//div[contains (@class, 'location-popup-loader')]//li//a[contains (@class, 'btn')]")} )
    private List<Button> selectButLocationList;

}
