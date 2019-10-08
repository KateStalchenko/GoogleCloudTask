package PageObjects;

import bo.BaseForm;
import bo.EstimateForm;
import bo.GoogleCloudCalculatorForm;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BasePage {
    protected final WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void waitForElementClickable(By by) {
        new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void openLinkInNewTab(String url) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.get(url);
    }

    public void switchToGoogleCloudTab() {
        switchToDefinedTab("Google Cloud Platform Pricing Calculator");
    }

    public void switchToTenMinutesTab() {
        switchToDefinedTab("10 Minute Mail");
    }

    private void switchToDefinedTab(String pageTitle) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (String tab : tabs) {
            if (driver.switchTo().window(tab).getTitle().contains(pageTitle)) {
                return;
            }
        }
    }

    public boolean areFormsSimilar(EstimateForm estimateForm, GoogleCloudCalculatorForm googleCloudCalculatorForm) {
        ArrayList<Boolean> isSimilar = new ArrayList<>();
        isSimilar.add(estimateForm.getVmClass().contains(googleCloudCalculatorForm.getVmClass()));
        isSimilar.add(estimateForm.getInstanceType().contains(googleCloudCalculatorForm.getInstanceType()));
        isSimilar.add(estimateForm.getRegion().contains(googleCloudCalculatorForm.getDatacenterLocation()));
        isSimilar.add(estimateForm.getLocalSSD().contains(googleCloudCalculatorForm.getLocalSSD()));
        isSimilar.add(estimateForm.getCommitmentTerm().contains(googleCloudCalculatorForm.getCommittedUsage()));
        if (isSimilar.contains(false)) {
            return false;
        }
        return true;
    }
}
