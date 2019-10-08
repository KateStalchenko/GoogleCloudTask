package PageObjects;

import Driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsAndServicesPage extends BasePage {
    ProductsAndServicesPage(WebDriver driver) {
        super(driver);
    }

    private By seePricingButtonLocator = By.xpath("//article[@id='cloud-site']//a[contains(text(), 'See Pricing')]");

    public void seePricing() {
        waitForElementClickable(seePricingButtonLocator);
        DriverSingleton.getDriver().findElement(seePricingButtonLocator).click();
    }
}
