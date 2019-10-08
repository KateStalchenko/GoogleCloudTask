package stepdefs;

import Driver.DriverSingleton;
import PageObjects.CalculatorPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FulfillFormSteps {
    @Given("User opened Google Cloud Platform Pricing Calculator page")
    public void userOpensGoogleCloudCalculatorPage(){
        new CalculatorPage(DriverSingleton.getDriver()).openCalculatorPage();
    }

    @When("^User fulfills Google Cloud Calculator form$")
    public void userFulfillsGoogleCloudCalculatorForm() {
        new CalculatorPage(DriverSingleton.getDriver()).fulfillForm();
    }

    @And("User adds to estimate")
    public void userAddsToEstimate(){
        new CalculatorPage(DriverSingleton.getDriver()).addToEstimate();
    }


//    @Then("^Estimate form contains equal data as Google Cloud Calculator form$")
//    public void estimateFormContainsEqualDataAsGoogleCloudCalculatorForm() {
//
//    }
}
