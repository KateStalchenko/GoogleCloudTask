package PageObjects;

import Driver.DriverSingleton;

public class Pages {
    private CalculatorPage calculatorPageObject;
    private EstimateComponent estimateComponentObject;
    private MainPage mainPageObject;
    private PricingPage pricingPageObject;
    private ProductsAndServicesPage productsAndServicesPageObject;
    private TenMinutesPage tenMinutesPageObject;
    private EmailEstimateComponent emailEstimateComponentObject;

    public CalculatorPage calculatorPage() {
        if (calculatorPageObject == null) {
            calculatorPageObject = new CalculatorPage(DriverSingleton.getDriver());
        }
        return calculatorPageObject;
    }

    public MainPage mainPage() {
        if (mainPageObject == null) {
            mainPageObject = new MainPage(DriverSingleton.getDriver());
        }
        return mainPageObject;
    }

    public EstimateComponent estimateComponent() {
        if (estimateComponentObject == null) {
            estimateComponentObject = new EstimateComponent(DriverSingleton.getDriver());
        }
        return estimateComponentObject;
    }

    public PricingPage pricingPage() {
        if (pricingPageObject == null) {
            pricingPageObject = new PricingPage(DriverSingleton.getDriver());
        }
        return pricingPageObject;
    }

    public ProductsAndServicesPage productsAndServicesPage() {
        if (productsAndServicesPageObject == null) {
            productsAndServicesPageObject = new ProductsAndServicesPage(DriverSingleton.getDriver());
        }
        return productsAndServicesPageObject;
    }

    public TenMinutesPage tenMinutesPage() {
        if (tenMinutesPageObject == null) {
            tenMinutesPageObject = new TenMinutesPage(DriverSingleton.getDriver());
        }
        return tenMinutesPageObject;
    }

    public EmailEstimateComponent emailEstimateComponent() {
        if (emailEstimateComponentObject == null) {
            emailEstimateComponentObject = new EmailEstimateComponent(DriverSingleton.getDriver());
        }
        return emailEstimateComponentObject;
    }
}
