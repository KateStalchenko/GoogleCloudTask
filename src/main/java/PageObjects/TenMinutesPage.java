package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinutesPage extends BasePage {

    TenMinutesPage(WebDriver driver) {
        super(driver);
    }

    private By emailLocator = By.id("mailAddress");
    private By emailSubject = By.xpath("//*[@id=\"ui-id-1\"]/span[contains(text(), 'Google Cloud Platform Price Estimate')]");

    public String getEmail() {
        waitForElementClickable(emailLocator);
        return driver.findElement(emailLocator).getAttribute("value");
    }

    public boolean isMessageSend() {
        WebElement messageIsSend = new WebDriverWait(driver, 200).until(ExpectedConditions.visibilityOfElementLocated(emailSubject));
        return messageIsSend != null;
    }
}
