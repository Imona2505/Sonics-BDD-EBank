package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import static Utilities.Hooks.driver;

public class OpeningHomePage {
    PageObjects.OpeningHomePage openingHomePage = PageFactory.initElements(driver, PageObjects.OpeningHomePage.class);

    @Given("User is on the homepage")
    public void user_is_on_the_homepage() {

        openingHomePage.homepage();
    }
    @When("User logs in")
    public void user_logs_in() {

    openingHomePage.loginwith("Demo-User", "Demo-Access1");

    }
    @Then("Verify the Log out button")
    public void verify_the_log_out_button() {

     openingHomePage.isLogOutButtonPresent();
    }

}
