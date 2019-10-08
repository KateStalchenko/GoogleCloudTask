import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class Runner {
    @CucumberOptions(
            strict = true,
            plugin = { "json:target/cucumber-report.json",
                    "html:target/cucumber-report"
            }
    )
    public class CucumberTestNGTest extends AbstractTestNGCucumberTests {
// some custom code stuff here
    }

}
