package pages.admin;

import data.ServicesData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import utils.ConfigProperties;

import java.util.List;

public class ServiceMapping extends BasePage {

    public ServiceMapping(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("adminServiceMapping.url"));
    }

    @FindBy(name = "ServiceMapSearch[name]")
    private TextInput serviceSearchField;

    @Name("ArrayList of edit service buttons")
    @FindBys( {@FindBy(xpath = "//a[@title='Edit']")} )
    private List<HtmlElement> listEditServBut;

    @Name("ArrayList of header service")
    @FindBys( {@FindBy(css = ".tv-header")} )
    private List<HtmlElement> listHeaderService;

    @Name("ArrayList of input fields")
    @FindBys( {@FindBy(css = ".tv-body li input")} )
    private List<TextInput> listInputFields;

    @FindBy(xpath = "//li[contains(@class, 'results')]")
    private Link linkCodeResult;

    @FindBy(xpath = "//button[contains(text(), 'Update')]")
    private Button updateBut;

    private void typeServiceCode(String headerService, String codeService) {
        for (int i = 0; i < listHeaderService.size(); i++) {
            if(headerService.equals(listHeaderService.get(i).getText())) {
                type(listInputFields.get(i), codeService);
                return;
            }
        }
    }

    private void searchService (String serviceName) {
        type(serviceSearchField, serviceName + Keys.ENTER);
        waitUntilTextInElementAppear(listEditServBut.get(0), "waiting");
        listEditServBut.get(0).click();
    }

    public void addCodeSerToNonMember(ServicesData servicesData) {
        searchService(servicesData.getServiceName());
        typeServiceCode("Non-member", servicesData.getCodeService());
        linkCodeResult.click();
        updateBut.click();
    }
}
