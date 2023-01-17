package PageObjects;

import io.restassured.http.Cookies;
import io.restassured.response.Response;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;

public class CardFundingTransferAPI {
    public static void main(String[] args) {
        String id = "56";
       Response response =
                 given().contentType("application/json").log().all()
                         .body("{\n" +
                                 "    \"data\": {\n" +
                                 "        \"email\": \"Bank-Admin\",\n" +
                                 "        \"password\": \"Demo-Access1\"\n" +
                                 "    }\n" +
                                 "}")
                .when().post("https://api-demo.ebanq.com/users/public/v1/auth/signin")
                .then().log().all().statusCode(200).extract().response();
        System.out.println(response);
        String token = response.path("data.accessToken");
        Cookies cookies = response.getDetailedCookies();
        Response response1 =
                 given().contentType("application/json").header("Authorization","Bearer "+token).cookies(cookies).log().all()
                .when().post("https://api-demo.ebanq.com/accounts/private/v1/admin/requests/execute/"+id)
                .then().log().all().statusCode(200).extract().response();
    }
}
