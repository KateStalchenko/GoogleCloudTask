package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String PATH_CHROME_DRIVER = "C:\\Data\\Drivers\\chromedriver_win32\\chromedriver.exe";

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty(CHROME_DRIVER, PATH_CHROME_DRIVER);
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
