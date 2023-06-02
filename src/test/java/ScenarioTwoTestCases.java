import DataPackage.Common;
import DataPackage.CreateUserPositiveTestData;
import RequestBuilderPackage.CreateUserRequest;
import RequestBuilderPackage.GenerateTokenRequest;
import RequestBuilderPackage.PostAuthorizeRequest;
import Utilis.UsernameExtractor;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ScenarioTwoTestCases implements CreateUserPositiveTestData, UsernameExtractor, Common {
    /*
    დავალებაში მოცემული Scenario 1-ში შემავალი ქეისები გავაერთიანე ერთი კლასის ქვეშ,
    რადგან ისინი მჭიდროდ იყო ერთმანეთთან დაკავშირებული და დამოუკიდებლად მათი გაშვება არ არის გამართლებული.
    კლასის დონეზე შექმნილია სამი String ცვლადი, რომელიც ინახავს response-დან გაპარსულ მნიშვნელობებს, რომელიც
    გამოიყენება ვალიდაციების დროს. ვალიდაციები ხორციელდება assertion-ების გამოყენებით.
    ასევე, შექმნილია სამი ობიექტი CreateUserRequest, GenerateTokenRequest და PostAuthorizeRequest კლასების საფუძველზე,
    რომლებიც უზრუნველყოფენ შესაბამისი Request-ების გაშვებას, ისე რომ მათი უშუალო იმპლემენტაცია არ ტვირთავს
    ტესტირებისთვის და ვალიდაციებისთვის განკუთვნილ ScenarioTwoTestCases კლასს.
     */
    String  createdUserId,
            createdUserName,
            createdPassword;
    CreateUserRequest createUserRequest = new CreateUserRequest();
    GenerateTokenRequest generateTokenRequest = new GenerateTokenRequest();
    PostAuthorizeRequest postAuthorized = new PostAuthorizeRequest();

    /*
    postUserTest მეთოდი ამოწმებს book-ში არის თუ არა ცარიელი სიმრავლე,
    ასევე ამოწმებს დამატებული სახელი არის თუ არა არგუმენტად გადაცემული სახელის იდენტური.
    მეთოდი პარამეტრებს იღებს dataProvider-ის საფუძველზე. ამასთან, მეთოდი არის საწყისი მეთოდი,
    რომელზეც დამოკიდებულია და დაშენებულია სხვა მეთოდები, ვინაიდან მის გარეშე სხვა მეთოდები ვერ შესრულდება.
     */
    @Test(priority = 1, dataProvider = "createUserPositiveScenarios")
    @Description("Check that books list equals to null and Check username value")
    public void postUserTest(String userName, String password) {
        String response = createUserRequest.createUserGetString(userName, password);

        createdPassword = password;
        createdUserName = extractValueFromResponse(response, usernameKey);
        createdUserId = extractValueFromResponse(response, userIDKey);

        assertEquals(extractValueFromResponse(response, booksKey), emptyStringKey);
        assertEquals(userName, createdUserName);
    }

    /*
    checkUserAuthorizationBeforeTokenGenerationTest ამოწმებს ტოკენის გენერაციამდე არის თუ არა
    რეგისტრირებული მომხარებელი ავტორიზებული. რექვესთის ტანი გატანილია RequestBuilderPackage-ში შემავალ კლასში
    ამიტომ კლასი არ არის გადატვირთული. პარამეტრებად კი გადაეცემა, postUserTest მეთოდის გამოყენების დროს
    რესპონსიდან დაბურნებული username და password, რათა შემოწმდეს მხოლოდ ის მომხმარებელი, რომელიც ტესტირების შედეგად შეიქმნა.
    მეთოდის შესრულება დამოკიდებულია postUserTest მეთოდზე.
     */
    @Test(priority = 2, dependsOnMethods = "postUserTest")
    @Description("Check that newly added user is not authorized")
    public void checkUserAuthorizationBeforeTokenGenerationTest() {
        String response = postAuthorized.postAuthorized(createdUserName, createdPassword);
        assertEquals(response, "false");
    }

    /*
    generateTokenTest აგზვნის რექვესთს postUserTest მეთოდით შექმნილი credential-ების საფუძველზე
    და შესაბამისი მომხარებლისთვის აგენერირებს ტოკენს. შემდეგ კი ასერშენების გამოყენებით მოწმდება
    სტატუსისა და ავტორიზაციის ტექსტები და ტოკენის გენერაციის წარმატებულობა.
     */
    @Test(priority = 3, dependsOnMethods = "postUserTest")
    @Description("Generate token and Validate status and result response values")
    public void generateTokenTest() {
        String response = generateTokenRequest.generateToken(createdUserName, createdPassword);
        assertEquals(extractValueFromResponse(response, statusKey), successfulTokenGenerationTxt);
        assertEquals(extractValueFromResponse(response, resultKey), successfulAuthorizationTxt);
    }

    /*
    checkUserAuthorizationAfterTokenGenerationTest ამოწმებს ტოკენის გენერაციის შემდეგ არის თუ არა
    რეგისტრირებული მომხარებელი ავტორიზებული. პარამეტრებად კი გადაეცემა, postUserTest მეთოდის გამოყენების დროს
    რესპონსიდან დაბურნებული username და password, რათა შემოწმდეს მხოლოდ ის მომხმარებელი, რომელიც ტესტირების შედეგად შეიქმნა.
    მეთოდის შესრულება დამოკიდებულია generateTokenTest მეთოდზე.
     */
    @Test(priority = 4, dependsOnMethods = "generateTokenTest")
    @Description("Check that user became authorized")
    public void checkUserAuthorizationAfterTokenGenerationTest() {
        String response = postAuthorized.postAuthorized(createdUserName, createdPassword);
        assertEquals(response, "true");
    }
}