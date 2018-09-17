package blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

@Block(@FindBy(className = "header-main"))
public class Header extends HtmlElement {

    @FindBy(xpath = "//a[@href='/sign-up']")
    private Link signUpLink;

    public void clickSignUpLink() {
        signUpLink.click();
    }

    public Link getSignInLink() {
        return signInLink;
    }

    @FindBy(xpath = "//a[@href='/account']")
    private Link signInLink;

    public void clickSignInLink() {
        signInLink.click();
    }

    public List<HtmlElement> getListMainNav() {
        return listMainNav;
    }

    @Name("ArrayList of main navigation items")
    @FindBys( {@FindBy(css = ".main-nav li")} )
    public List<HtmlElement> listMainNav;

    public void clickMenuItem(String itemName) {
        List<HtmlElement> list = listMainNav;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getText().equals(itemName.toUpperCase())) {
                list.get(i).click();
                return;
            }
        }
        list.get(list.size() - 1).click();
    }

    @FindBy(xpath = "//div[@class='your-location']//a[contains(text(), 'Change Location')]")
    private Link changeLocationLink;

    public void clickChangeLocationLink() {
        changeLocationLink.click();
    }

}
