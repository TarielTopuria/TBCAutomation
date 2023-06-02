package RequestBuilderPackage;

import DataPackage.Common;
import RequestBodyBuilderPackage.CreateUserBody;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class GenerateTokenRequest implements Common {
    /*
    GenerateTokenRequest კლასის ქვეშ შექმნილი მაქვს მეთოდი, რომელიც Post მეთოდის გამოყენებით
    აგენერირებს ტოკენს. მეთოდი გამოიყენება ტესტ ქეისში ვალიდაციებისთვის, ვალიდაციისთვის მჭირდებოდა
    String-ში გაპარსული მნიშვნელობის დაბრუნება, შესაბამისად მეთოდი აბრუნებს String მნიშვნელობას.
     */
    public String generateToken(String userName, String password){
        JsonObject requestBody = CreateUserBody.createUserBody(userName, password);

        return given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                .when()
                    .post(baseUrl.concat(generateTokenUrl))
                .then()
                    .extract()
                    .response()
                    .asString();
    }
}
