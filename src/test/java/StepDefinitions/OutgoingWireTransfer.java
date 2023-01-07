package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utilities.Hooks.driver;

public class OutgoingWireTransfer {
    PageObjects.OpeningHomePage openingHomePage = PageFactory.initElements(driver, PageObjects.OpeningHomePage.class);
    PageObjects.OutgoingWireTransfer outgoingWireTransfer = PageFactory.initElements(driver, PageObjects.OutgoingWireTransfer.class);
    @When("User transfers money")
    public void user_transfers_money()throws InterruptedException {

        openingHomePage.loginwith("Demo-User", "Demo-Access1");
        outgoingWireTransfer.outgoingWireTransfer("SMCOGB2L", "Adam", "123 Bronx Ave", "Bronx", "New York","United States of America", "AL35202111090000000001234567", "Test","1000", "USD");
    }
    @Then("User successfully transfer money")
    public void user_successfully_transfer_money() {
        outgoingWireTransfer.isSuccessMessagePresent();

    }
}
