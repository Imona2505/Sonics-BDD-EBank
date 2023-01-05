package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import static Utilities.Hooks.driver;

public class TransferBetweenUser {

        PageObjects.OpeningHomePage openingHomePage = PageFactory.initElements(driver, PageObjects.OpeningHomePage.class);
        PageObjects.TransferBetweenUser transferBetweenUser = PageFactory.initElements(driver,PageObjects.TransferBetweenUser.class);

        @Given("User is on homepage")
        public void user_is_on_homepage() {

            openingHomePage.homepage();
        }
        @When("User transfers money between users")
    public void user_transfers_money_between_users() {
        transferBetweenUser.TransferBetweenUser("mjohnson", "EBQ12123423456", "500");
    }
    @Then("User successfully transferred money")
    public void user_successfully_transferred_money() {
       transferBetweenUser.isSuccessMessagePopUp();
    }

}
