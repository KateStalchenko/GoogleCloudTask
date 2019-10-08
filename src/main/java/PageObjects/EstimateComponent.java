package PageObjects;

import bo.EstimateForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EstimateComponent extends BasePage {
    public EstimateForm estimateFormObject = fulfillEstimateFormObject();

    private EstimateForm fulfillEstimateFormObject() {
        EstimateForm estimateForm = new EstimateForm();
        estimateForm.setVmClass(getTextOfVMClass());
        estimateForm.setInstanceType(getTextOfInstanceType());
        estimateForm.setRegion(getTextOfRegion());
        estimateForm.setLocalSSD(getTextOfLocalSSD());
        estimateForm.setCommitmentTerm(getTextOfCommitmentTerm());
        return estimateForm;
    }

    EstimateComponent(WebDriver driver) {
        super(driver);
    }

    private By vmClassLocator = By.xpath("//*[@id=\"compute\"]//div[contains(text(), 'VM class:')]");
    private By instanceTypeLocator = By.xpath("//*[@id=\"compute\"]//div[contains(text(), 'Instance type')]");
    private By regionLocator = By.xpath("//*[@id=\"compute\"]//div[contains(text(), 'Region')]");
    private By localSSDSpaceLocator = By.xpath("//*[@id=\"compute\"]//div[contains(text(), 'Total available local SSD space')]");
    private By commitmentTermLocator = By.xpath("//*[@id=\"compute\"]//div[contains(text(), 'Commitment term')]");
    private By emailEstimateLocator = By.xpath("//button[contains(text(), 'Email Estimate')]");

    private By iframe = By.id("idIframe");

    private String getTextOfElement(By by) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(iframe));
        String textOfElement = driver.findElement(by).getText();
        driver.switchTo().defaultContent();
        return textOfElement;
    }

    public String getTextOfVMClass() {
        return getTextOfElement(vmClassLocator);
    }

    public String getTextOfInstanceType() {
        return getTextOfElement(instanceTypeLocator);
    }

    public String getTextOfRegion() {
        return getTextOfElement(regionLocator);
    }

    public String getTextOfLocalSSD() {
        return getTextOfElement(localSSDSpaceLocator);
    }

    public String getTextOfCommitmentTerm() {
        return getTextOfElement(commitmentTermLocator);
    }

    public void sendEstimatedBillOnEmail() {
        driver.switchTo().frame(driver.findElement(iframe));
        driver.findElement(emailEstimateLocator).click();
        driver.switchTo().defaultContent();
    }

    public EstimateForm getEstimateFormObject() {
        return estimateFormObject;
    }
}
