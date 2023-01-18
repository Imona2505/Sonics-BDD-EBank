package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.fetch.model.AuthChallengeResponse;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utilities.Hooks.driver;
import static io.restassured.RestAssured.given;

public class OutgoingWireTransfer {
    PageObjects.OpeningHomePage openingHomePage = PageFactory.initElements(driver, PageObjects.OpeningHomePage.class);
    PageObjects.OutgoingWireTransfer outgoingWireTransfer = PageFactory.initElements(driver, PageObjects.OutgoingWireTransfer.class);
    @Given("User is on the homepage")
    public void user_is_on_the_homepage() {

    }
    @When("User transfers money")
    public void user_transfers_money()throws InterruptedException {

        openingHomePage.loginwith("Demo-User", "Demo-Access1");
        outgoingWireTransfer.outgoingWireTransfer("SMCOGB2L", "Adam", "123 Bronx Ave", "Bronx", "New York","United States of America", "AL35202111090000000001234567", "Test","1", "USD");
    }
    @Then("User successfully transfer money")
    public void user_successfully_transfer_money() {
        outgoingWireTransfer.isSuccessMessagePresent();

    }
    @When("Admin approves the transaction")
    public void admin_approves_the_transaction() {
        Response response = given().contentType("application/json").log().all()
                .body("{\n" +
                        "    \"data\": {\n" +
                        "        \"email\": \"Bank-Admin\",\n" +
                        "        \"password\": \"Demo-Access1\"\n" +
                        "    }\n" +
                        "}")
                .when().post("https://api-demo.ebanq.com/users/public/v1/auth/signin")
                .then().log().all().statusCode(200).extract().response();
       String token = response.path("data.accessToken");
       Cookies cookies= response.getDetailedCookies();

        Response response1 = given().contentType("application/json").header("Authorization", "Bearer "+token).cookies(cookies).log().all()
                .when().post("https://api-demo.ebanq.com/accounts/private/v1/admin/requests/execute/"+outgoingWireTransfer.getTransactionId())
                .then().log().all().statusCode(200).extract().response();


    }
}
