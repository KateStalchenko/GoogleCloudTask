package PageObjects;

import Driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PricingPage extends BasePage {
    PricingPage(WebDriver driver) {
        super(driver);
    }

    private By calculatorsLocator = By.xpath("//article[@id='cloud-site']//a[contains(text(), 'Calculators')]");

    public void clickOnCalculators() {
        waitForElementClickable(calculatorsLocator);
        DriverSingleton.getDriver().findElement(calculatorsLocator).click();
    }
}
