package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.*;

/**
 * Created by bigdrop on 8/31/2018.
 */
@Listeners(MyTestListener.class)
public class TestBase {
    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    private WebDriver driver;

    @BeforeClass
    public WebDriver initDriver() {
        if (driver == null) {
            app.setup();
            driver = app.unit();
        }
        return app.getDriver();
    }

    @BeforeMethod
    public void screenShot(ITestContext context) {
        context.setAttribute("app", app);
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }
}
