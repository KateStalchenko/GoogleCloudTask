package PageObjects;

import bo.GoogleCloudCalculatorForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends BasePage {

    public GoogleCloudCalculatorForm googleCloudCalculatorForm = new GoogleCloudCalculatorForm();

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    private final String NUMBER_OF_INSTANCES = "4";
    private final String CALCULATOR_URL = "https://cloud.google.com/products/calculator/";

    private By computerEngineLocator = By.xpath("//*[@id=\"mainForm\"]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]/div[1]");

    private By numberOfInstancesLocator = By.xpath("//md-input-container[label[contains(text(), 'Number of instances')]]//input");

    private By operatingSystemLocator = By.xpath("//md-select[@class='ng-pristine ng-untouched ng-valid ng-not-empty'][contains(@aria-label, 'Operating System / Software')]");
    private By freeVariantForOperatingSystemLocator = By.xpath("//*[@id=\"select_option_48\"]/div[contains(text(), 'Free')]");

    private By vmClassLocator = By.id("select_value_label_41");
    private By regularVariantForVMClass = By.xpath("//*[@id=\"select_option_60\"]/div[contains(text(), 'Regular')]");
    private By selectedVmClass = By.xpath("//md-select-value[@id='select_value_label_41']//div");

    private By instanceTypeLocator = By.id("select_value_label_42");
    private By variantForInstanceTypeLocator = By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");
    private By selectedInstance = By.xpath("//md-select-value[@id='select_value_label_42']//div");

    private By addGPUsLocator = By.xpath("//md-input-container//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']");
    private By numberOfGPUsLocator = By.xpath("//*[@id=\"select_329\"]");
    private By variantOneForNumberOfGPUs = By.xpath("//*[@id=\"select_option_334\"]");
    private By selectedNumberOfGPUs = By.xpath("//md-select[@placeholder='Number of GPUs']//md-select-value//div");

    private By gpuTypeLocator = By.xpath("//md-select[@placeholder='GPU type']");
    private By variantForGPUType = By.xpath("//md-option[@value='NVIDIA_TESLA_V100']");
    private By selectedGPUType = By.xpath("//md-select[@placeholder='GPU type']//md-select-value//div");

    private By localSSDLocator = By.id("select_value_label_43");
    private By variantForLocaleSSD = By.xpath("//md-option[div[text()='2x375 GB']]");
    private By selectedlocalSSD = By.xpath("//md-select[@placeholder='Local SSD']//md-select-value//div");

    private By datacenterLocationLocator = By.xpath("//form[@name='ComputeEngineForm']//md-select[contains(@ng-model, \"location\")][@placeholder='Datacenter location']");
    private By variantFrankfurtForDatacenterLocation = By.xpath("//md-select-menu[@class='md-overflow']//md-option[div[contains(text(), 'Frankfurt')]]");

    private By committedUsageLocator = By.xpath("//form[@name='ComputeEngineForm']//md-select[@placeholder='Committed usage']");
    private By variantOneYearForCommittedUsage = By.xpath("//*[@id=\"select_option_100\"]/div[text()='1 Year']");

    private By addToEstimateButton = By.xpath("//*[@id=\"mainForm\"]//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']");

    private By iframe = By.id("idIframe");

    public void activateComputerEngineButton() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(iframe));
        driver.switchTo().frame(driver.findElement(iframe));
        waitForElementClickable(computerEngineLocator);
        driver.findElement(computerEngineLocator).click();
        driver.switchTo().defaultContent();
    }

    public void fulfillForm() {
        driver.switchTo().frame(driver.findElement(iframe));
        fulfillNumberOfInstance();
        chooseOperatingSystem();
        chooseVMClass();
        chooseInstanceType();
        addGPUs();
        setLocalSSD();
        setDatacenterLocation();
        setCommittedUsage();
        driver.switchTo().defaultContent();
    }

    private void fulfillNumberOfInstance() {
        waitForElementClickable(numberOfInstancesLocator);
        driver.findElement(numberOfInstancesLocator).sendKeys(NUMBER_OF_INSTANCES);
        googleCloudCalculatorForm.setNumberOfInstance(NUMBER_OF_INSTANCES);
    }

    private void chooseOperatingSystem() {
        waitForElementClickable(operatingSystemLocator);
        driver.findElement(operatingSystemLocator).click();
        waitForElementClickable(freeVariantForOperatingSystemLocator);
        driver.findElement(freeVariantForOperatingSystemLocator).click();
        googleCloudCalculatorForm.setOperatingSystem(getOperatingSystem());
    }

    private String getOperatingSystem() {
        return driver.findElement(operatingSystemLocator).getText();
    }

    private void chooseVMClass() {
        waitForElementClickable(vmClassLocator);
        driver.findElement(vmClassLocator).click();
        waitForElementClickable(regularVariantForVMClass);
        driver.findElement(regularVariantForVMClass).click();
        googleCloudCalculatorForm.setVmClass(getVmClass());
    }

    private String getVmClass() {
        return driver.findElement(selectedVmClass).getText();
    }

    private void chooseInstanceType() {
        waitForElementClickable(instanceTypeLocator);
        driver.findElement(instanceTypeLocator).click();
        waitForElementClickable(variantForInstanceTypeLocator);
        driver.findElement(variantForInstanceTypeLocator).click();
        googleCloudCalculatorForm.setInstanceType(getInstanceType());
    }

    private String getInstanceType() {
        return driver.findElement(selectedInstance).getText();
    }

    private void addGPUs() {
        waitForElementClickable(addGPUsLocator);
        driver.findElement(addGPUsLocator).click();
        setNumberOfGPUs();
        setGPUType();
    }

    private void setGPUType() {
        waitForElementClickable(gpuTypeLocator);
        driver.findElement(gpuTypeLocator).click();
        waitForElementClickable(variantForGPUType);
        driver.findElement(variantForGPUType).click();
        googleCloudCalculatorForm.setGpuType(getGPUType());
    }

    private String getGPUType() {
        return driver.findElement(selectedGPUType).getText();
    }

    private void setNumberOfGPUs() {
        waitForElementClickable(numberOfGPUsLocator);
        driver.findElement(numberOfGPUsLocator).click();
        WebElement element = driver.findElement(variantOneForNumberOfGPUs);
        element.click();
        googleCloudCalculatorForm.setNumberOfGPUs(getNumberOfGPUs());
    }

    private String getNumberOfGPUs() {
        return driver.findElement(selectedNumberOfGPUs).getText();
    }

    private void setLocalSSD() {
        waitForElementClickable(localSSDLocator);
        driver.findElement(localSSDLocator).click();
        waitForElementClickable(variantForLocaleSSD);
        driver.findElement(variantForLocaleSSD).click();
        googleCloudCalculatorForm.setLocalSSD(getLocalSSD());
    }

    private String getLocalSSD() {
        return driver.findElement(selectedlocalSSD).getText();
    }

    private void setDatacenterLocation() {
        waitForElementClickable(numberOfGPUsLocator);
        driver.findElement(datacenterLocationLocator).click();
        waitForElementClickable(variantFrankfurtForDatacenterLocation);
        driver.findElement(variantFrankfurtForDatacenterLocation).click();
        googleCloudCalculatorForm.setDatacenterLocation(getDatacenterLocation());
    }

    private String getDatacenterLocation() {
        return driver.findElement(datacenterLocationLocator).getText();
    }

    private void setCommittedUsage() {
        waitForElementClickable(committedUsageLocator);
        driver.findElement(committedUsageLocator).click();
        waitForElementClickable(variantOneYearForCommittedUsage);
        driver.findElement(variantOneYearForCommittedUsage).click();
        googleCloudCalculatorForm.setCommittedUsage(getCommittedUsage());
    }

    private String getCommittedUsage() {
        return driver.findElement(committedUsageLocator).getText();
    }

    public void addToEstimate() {
        driver.switchTo().frame(driver.findElement(iframe));
        waitForElementClickable(addToEstimateButton);
        driver.findElement(addToEstimateButton).click();
        driver.switchTo().defaultContent();
    }

    public GoogleCloudCalculatorForm getGoogleCloudCalculatorForm() {
        return googleCloudCalculatorForm;
    }

    public void openCalculatorPage(){
        driver.navigate().to(CALCULATOR_URL);
    }
}