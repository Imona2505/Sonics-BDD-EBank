package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.openqa.selenium.support.PageFactory;

import static Utilities.Hooks.driver;
import static io.restassured.RestAssured.given;

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
       transferBetweenAccounts.transferBetweenAccounts("100");
    }
    @Then("User gets success message")
    public void user_gets_success_message(){
        transferBetweenAccounts.isSuccessMessagePopUp();

    }
    @When("Admin approves transaction")
    public void admin_approves_transaction(){
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
                .when().post("https://api-demo.ebanq.com/accounts/private/v1/admin/requests/execute/"+transferBetweenAccounts.getTransactionId())
                .then().log().all().statusCode(200).extract().response();


    }
}
