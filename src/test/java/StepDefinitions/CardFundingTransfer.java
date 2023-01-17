package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.openqa.selenium.devtools.v104.fetch.model.AuthChallengeResponse;
import org.openqa.selenium.support.PageFactory;

import static Utilities.Hooks.driver;
import static io.restassured.RestAssured.given;

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
    @When("Admin should approve transaction")
    public void admin_should_approve_transaction() {

        Response response = given().contentType("application/json").log().all()
                .body("{\"data\":{\"email\":\"Bank-Admin\",\"password\":\"Demo-Access1\"}}")
                .when().post("https://api-demo.ebanq.com/users/public/v1/auth/signin")
                .then().log().all().statusCode(200).extract().response();
        String token= response.path("data.accessToken");
        Cookies cookies=response.getDetailedCookies();
        //System.out.println(response);
        Response response1 = given().contentType("application/json").header("Authorization","Bearer "+token).cookies(cookies).log().all()
                .when().post("https://api-demo.ebanq.com/accounts/private/v1/admin/requests/execute/"+cardFundingTransfer.getTransactionID())
                .then().log().all().statusCode(200).extract().response();
        System.out.println(response1);
    }



}
