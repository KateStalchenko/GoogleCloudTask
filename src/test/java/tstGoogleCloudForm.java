
import org.testng.Assert;
import org.testng.annotations.Test;

public class tstGoogleCloudForm extends tstBase {

    @Test
    public void tstFulfillGoogleCloudForm() {
        pages.mainPage().openPage("https://cloud.google.com/");
        pages.mainPage().exploreAllProducts();
        pages.productsAndServicesPage().seePricing();
        pages.pricingPage().clickOnCalculators();
        pages.calculatorPage().activateComputerEngineButton();
        pages.calculatorPage().fulfillForm();
        pages.calculatorPage().addToEstimate();

        Assert.assertTrue(pages.mainPage().areFormsSimilar(pages.estimateComponent().getEstimateFormObject(), pages.calculatorPage().getGoogleCloudCalculatorForm()));
    }
}
