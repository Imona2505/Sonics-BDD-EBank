import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        tags = "@regression",
        plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"}
)



public class TestRunner {

}
