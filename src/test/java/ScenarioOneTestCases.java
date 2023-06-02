import DataPackage.CreateUserNegativeTestData;
import RequestBuilderPackage.CreateUserRequest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScenarioOneTestCases implements CreateUserNegativeTestData {
    /*
    დავალებაში მოცემული Scenario 1-ში შემავალი ქეისები გავაერთიანე ერთი კლასის ქვეშ,
    რადგან ისინი მჭიდროდ იყო ერთმანეთთან დაკავშირებული. ამასთან, გამოიყენება მხოლოდ ერთი მეთოდი,
    რომელიც სამ მნიშვნელობაზე იტესტება, რომელიც გადაეცემა dataProvider-სგან.
    ტესტ ქეისი ამოწმებს response-ში დაბრუნებულ code და message-ს და ადარებს მას
    დავალებაში მოცემულ response -თან. შესამოწმებელი მნიშვნელობები ასევე გადაცემულია dataProvider-ის მეშვეობით.
     */
    CreateUserRequest createRequest = new CreateUserRequest();

    @Test(dataProvider = "negativeScenarios")
    @Description("Validate response code and message of AccountV1UserPost method")
    public void testNegativeScenarios(String userName, String password, String expectedCode, String expectedMessage) {
        Response response = createRequest.createUser(userName, password);

        String actualResponseBody = response.getBody().asString();
        Assert.assertTrue(actualResponseBody.contains(expectedCode), "Incorrect code in the response");
        Assert.assertTrue(actualResponseBody.contains(expectedMessage), "Incorrect message in the response");
    }
}