import Driver.DriverSingleton;
import PageObjects.Pages;
import bo.EstimateForm;
import bo.GoogleCloudCalculatorForm;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class tstBase {
    Pages pages = new Pages();
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass
    public void afterClass() {
        DriverSingleton.closeDriver();
    }
}
