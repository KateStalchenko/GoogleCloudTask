package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailEstimateComponent extends BasePage {
    EmailEstimateComponent(WebDriver driver) {
        super(driver);
    }

    private By emailInputLocator = By.xpath("//input[@ng-model='emailQuote.user.email']");
    private By sendEmailButtonLocator = By.xpath("//button[contains(text(), 'Send Email')]");
    private By iframe = By.id("idIframe");

    public void fulfillEmailInput(String email) {
        driver.switchTo().frame(driver.findElement(iframe));
        driver.findElement(emailInputLocator).sendKeys(email);
        driver.switchTo().defaultContent();
    }

    public void sendEmail() {
        driver.switchTo().frame(driver.findElement(iframe));
        driver.findElement(sendEmailButtonLocator).click();
        driver.switchTo().defaultContent();
    }
}
