package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.openqa.selenium.support.PageFactory;

import static Utilities.Hooks.driver;
import static io.restassured.RestAssured.given;

public class TransferBetweenUser {

    PageObjects.OpeningHomePage openingHomePage = PageFactory.initElements(driver, PageObjects.OpeningHomePage.class);
    PageObjects.TransferBetweenUser transferBetweenUser = PageFactory.initElements(driver, PageObjects.TransferBetweenUser.class);



    @Given("User is on homepage")
    public void user_is_on_homepage() {


        openingHomePage.homepage();
        openingHomePage.loginwith("Demo-User", "Demo-Access1");
    }

    @When("User transfers money between users")
    public void user_transfers_money_between_users() throws InterruptedException {
        transferBetweenUser.TransferBetweenUser("mjohnson", "EBQ12123423456", "1");
    }

    @Then("User successfully transferred money")
    public void user_successfully_transferred_money() {
        transferBetweenUser.isSuccessMessagePopUp();
    }

    @When("Admin approves transfer between users transaction")
    public void admin_approves_transfer_between_users_transaction(){
        Response response=
                given().contentType("application/json").log().all()
                        .body("{\n" +
                                "    \"data\": {\n" +
                                "        \"email\": \"Bank-Admin\",\n" +
                                "        \"password\": \"Demo-Access1\"\n" +
                                "    }\n" +
                                "}")
                        .when().post("https://api-demo.ebanq.com/users/public/v1/auth/signin")
                        .then().log().all().statusCode(200).extract().response();
        String token=response.path("data.accessToken");
    Cookies cookies=response.getDetailedCookies();

        Response response1 = given().contentType("application/json").header("Authorization","Bearer "+token).cookies(cookies).log().all()
                .when().post("https://api-demo.ebanq.com/accounts/private/v1/admin/requests/execute/"+transferBetweenUser.getTransactionId())
                .then().log().all().statusCode(200).extract().response();





    }

}
