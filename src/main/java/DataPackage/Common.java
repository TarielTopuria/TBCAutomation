package DataPackage;

public interface Common {
    /*
    Common ინტერფეისში გავიტანე ყველა ზოგადი მნიშვნელობა, რომელიც სხვადასხვა კლასსა თუ ინტერფეისში მჭირდებოდა,
    რაც ამარტივებს კოდის კითხვადობას და ცვლილებების მიმართ მოქნილობას.
     */
    String
            baseUrl = "https://bookstore.toolsqa.com",
            userPostUrl = "/Account/v1/User",
            authorizedPostUrl = "/Account/v1/Authorized",
            generateTokenUrl = "/Account/v1/GenerateToken",
            usernameKey = "username",
            booksKey = "books",
            userIDKey = "userID",
            emptyStringKey = "[]",
            statusKey = "status",
            resultKey = "result",
            successfulTokenGenerationTxt = "Success",
            successfulAuthorizationTxt = "User authorized successfully.";
}
