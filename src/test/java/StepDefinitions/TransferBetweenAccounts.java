package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import static Utilities.Hooks.driver;

public class TransferBetweenAccounts {
    PageObjects.OpeningHomePage openingHomePage = PageFactory.initElements(driver, PageObjects.OpeningHomePage.class);
    PageObjects.TransferBetweenAccounts transferBetweenAccounts = PageFactory.initElements(driver, PageObjects.TransferBetweenAccounts.class);

    @Given("User is on the homepages")
    public void user_is_on_the_homepages(){
        openingHomePage.homepage();
        openingHomePage.loginwith("Demo-User", "Demo-Access1");
    }


    @When("User Transferred money")
    public void user_transferred_money() throws InterruptedException {
       transferBetweenAccounts.TransferBetweenAccounts("EBQ11113487654",  "EBQ38495629375", "100");
    }
    @Then("User gets success message")
    public void user_gets_success_message(){
        transferBetweenAccounts.isSuccessMessagePopUp();

    }
}
