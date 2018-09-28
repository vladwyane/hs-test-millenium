package pages;

import blocks.Header;
import blocks.LocationsNav;
import blocks.popUps.FirstVisitPopup;
import blocks.popUps.LocationPopup;
import data.LocationsData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import utils.ConfigProperties;

import java.util.List;

/**
 * Created by bigdrop on 9/17/2018.
 */
public class Locations extends BasePage{

    public Locations(WebDriver driver) {
        super(driver);
    }

    private LocationsNav locationsNav;
    private Header header;
    private LocationPopup locationPopup;
    private FirstVisitPopup firstVisitPopup;

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("locations.url"));
        if (waitUntilElementAppeared(firstVisitPopup) == true)
            firstVisitPopup.clickCloseBut();
    }

    @Name("ArrayList of buttons more details locations")
    @FindBys( {@FindBy(xpath = "//a[contains(text(), 'More details')]")} )
    public List<Button> listButDetailLocation;

    @Name("ArrayList of buttons available locations")
    @FindBys( {@FindBy(xpath = "//a[contains(text(), 'Make it my store')]")} )
    public List<Button> listButAvailableLocation;

    public Locations chooseLocationFromLocationPage(LocationsData locationsData) {
        type(locationsNav.getSearchField(), locationsData.getShortLocationName());
        locationsNav.getListLocationFromAutocom().get(0).click();
        locationsNav.clickFindStoreBut();
        listButAvailableLocation.get(0).click();
        return this;
    }

    public Locations moveToLocationDetail(LocationsData locationsData) {
        type(locationsNav.getSearchField(), locationsData.getShortLocationName());
        locationsNav.getListLocationFromAutocom().get(0).click();
        locationsNav.clickFindStoreBut();
        listButDetailLocation.get(0).click();
        return this;
    }

    public void clickLocationItemFromMainNav() {
        waitUntilTextInElementAppear(header, "Waiting");
        header.clickMenuItem("Location");
    }

    public void changeLocation(LocationsData locationsData) {
        header.clickChangeLocationLink();
        locationPopup.clickFindLocationLink();
        for (int i = 0; i < locationPopup.getTitlesLocationList().size(); i++) {
            if(isElementInvisible(locationPopup.getTitlesLocationList().get(i)) == true)
                locationPopup.clickRightArrowOfCarousel();
            if(locationPopup.getTitlesLocationList().get(i).getText().contains(locationsData.getShortLocationName().toUpperCase())) {
                locationPopup.getSelectButLocationList().get(i).click();
                return;
            }
        }
        locationPopup.getSelectButLocationList().get(locationPopup.getSelectButLocationList().size() - 1).click();
    }
}
