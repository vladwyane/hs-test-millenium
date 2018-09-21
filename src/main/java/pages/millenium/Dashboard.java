package pages.millenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

/**
 * Created by bigdrop on 9/21/2018.
 */
public class Dashboard extends BasePage {

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(id = "divSchedule")
    private Link scheduleNavLink;

    @FindBy(id = "divData")
    private Link dataNavLink;

    @Name("ArrayList of subNavigation items")
    @FindBys( {@FindBy(xpath = "//div[@class='option']")} )
    private List<HtmlElement> subNavItemList;

    private void clickSubNavItem(String subItemName) {
        for (int i = 0; i < subNavItemList.size(); i++) {
            if(subItemName.equals(subNavItemList.get(i).getText())) {
                subNavItemList.get(i).click();
                return;
            }
        }
    }

    public ScheduleEditor moveToScheduleEditor() {
        scheduleNavLink.click();
        clickSubNavItem("Schedule Editor");
        return new ScheduleEditor(driver);
    }

    public Employee moveToEmployee() {
        dataNavLink.click();
        clickSubNavItem("Employees");
        return new Employee(driver);
    }

}
