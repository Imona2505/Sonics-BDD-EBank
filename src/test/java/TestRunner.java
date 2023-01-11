
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/features"},
        tags = "@regression",
        plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"}
)



public class TestRunner extends AbstractTestNGCucumberTests {
}
