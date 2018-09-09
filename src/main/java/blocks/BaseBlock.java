package blocks;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class BaseBlock extends HtmlElement {

    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    protected BaseBlock(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
    }


}
