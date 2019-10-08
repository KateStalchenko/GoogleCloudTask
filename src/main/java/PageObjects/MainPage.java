package PageObjects;

import Driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By exploreAllProductsButtonLocator = By.xpath("//div[@id='gc-wrapper']//a[contains(text(), 'Explore all products')]");

    public void exploreAllProducts() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(exploreAllProductsButtonLocator));
        DriverSingleton.getDriver().findElement(exploreAllProductsButtonLocator).click();
    }
}
