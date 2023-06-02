package RequestBuilderPackage;

import RequestBodyBuilderPackage.CreateUserBody;
import DataPackage.Common;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUserRequest implements Common{
    /*
    CreateUserRequest კლასის ქვეშ შექმნილი მაქვს ორი მეთოდი, createUser და createUserGetString,
    რომელიც ასრულებს Post მეთოდს და შემდეგ იღებს დაბრუნებულ პასუხს, ან Response ობიექტის ან String ობიექტის სახით.
    ეს მეთოდები გამოიყენება უშუალოდ ტესტ ქეისებში. createUser მეთოდი აბრუნებს Response ტიპის ობიექტს,
    ხოლო createUserGetString მეთოდი აბრუნებს String ობიექტს. ორივე მათგანი გამოიყენება Request-ის შედეგად
    დაბრუნებული Response-ების დამუშავებისთვის უშუალოდ ტესტ ქეისებში.
    */
    public Response createUser(String userName, String password) {
        JsonObject requestBody = CreateUserBody.createUserBody(userName, password);

        return RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                .when()
                    .post(baseUrl.concat(userPostUrl));
    }

    public String createUserGetString(String userName, String password) {
        JsonObject requestBody = CreateUserBody.createUserBody(userName, password);

        return RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                .when()
                    .post(baseUrl.concat(userPostUrl))
                .then()
                    .extract()
                    .response()
                    .asString();
    }
}