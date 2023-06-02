package RequestBuilderPackage;

import DataPackage.Common;
import RequestBodyBuilderPackage.CreateUserBody;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class PostAuthorizeRequest implements Common {
    /*
    PostAuthorizeRequest კლასის ქვეშ მაქვს შექმნილი მეთოდი, რომელიც Post მეთოდის გამოყენებით
    აგზავნის რექვესთს და იღებს რესპონსს, იმის მიხედვით ბოდიში გადაცემული username და password-ის
    მქონე იუზერი ავტორიზებულია თუ არა. მეთოდი გამოიყენება ტესტ ქეისებში ვალიდაციისთვის,
    მეთოდი აბრუნებს გაპარსულ String ობიექტს.
     */
    public String postAuthorized(String userName, String password){
        JsonObject requestBody = CreateUserBody.createUserBody(userName, password);

        return given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                .when()
                    .post(baseUrl.concat(authorizedPostUrl))
                .then()
                    .extract()
                    .response()
                    .asString();
    }
}
