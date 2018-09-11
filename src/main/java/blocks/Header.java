package blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

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
}
