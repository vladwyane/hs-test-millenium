package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

/**
 * Created by bigdrop on 9/21/2018.
 */
public class AdminDashboad extends BasePage {

    public AdminDashboad(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(id = "menu-trigger")
    private Button burgerBut;

    @Name("ArrayList of main menu items")
    @FindBys( {@FindBy(css = ".main-menu li")} )
    private List<HtmlElement> mainMenuItemList;

    private void clickMainMenuItem(String menuItemName) {
        for (int i = 0; i < mainMenuItemList.size(); i++) {
            if(menuItemName.equals(mainMenuItemList.get(i).getText())) {
                mainMenuItemList.get(i).click();
                return;
            }
        }
    }
}
