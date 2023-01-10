package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import static Utilities.Hooks.driver;


public class IncomingWireTransfer {

    PageObjects.IncomingWireTransfer incomingWireTransfer = PageFactory.initElements(driver, PageObjects.IncomingWireTransfer.class);
    PageObjects.IncomingWireTransferPage incomingWireTransferPage = PageFactory.initElements(driver, PageObjects.IncomingWireTransferPage.class);

    @Given("User is logs in")
    public void user_is_logs_in() {
         incomingWireTransfer.homepage();
         incomingWireTransfer.LogIn("Demo-User","Demo-Access1");
    }
    @When("User makes an incoming wire transfer")
    public void user_makes_an_incoming_wire_transfer()throws InterruptedException {
        incomingWireTransfer.sideRowTransfer();
        incomingWireTransferPage.process();
    }
    @Then("User gets the verify message")
    public void user_gets_the_verify_message() {
        incomingWireTransfer.isSuccessMessagePresent();
    }
}
