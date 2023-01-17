package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import static Utilities.Hooks.driver;

public class CardFundingTransfer {
    PageObjects.OpeningHomePage openingHomePage = PageFactory.initElements(driver, PageObjects.OpeningHomePage.class);
    PageObjects.CardFundingTransfer cardFundingTransfer = PageFactory.initElements(driver, PageObjects.CardFundingTransfer.class);
    public void user_is_on_the_homepage(){
        openingHomePage.homepage();
        openingHomePage.loginwith("Demo-User", "Demo-Access1");
    }
    @When("User tries to transfer between cards")
    public void user_tries_to_transfer_between_cards()throws InterruptedException {

        openingHomePage.loginwith("Demo-User", "Demo-Access1");
        cardFundingTransfer.process("1");
    }
    @Then("User should successfully transfer")
    public void user_should_successfully_transfer() {
        cardFundingTransfer.isSuccessMessagePresent();
    }


}
