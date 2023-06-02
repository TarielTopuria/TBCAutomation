package DataPackage;

import org.testng.annotations.DataProvider;

public interface CreateUserNegativeTestData {
    /*
    CreateUserNegativeTestData ინტერფეისში DataProvider ანოტაციის ქვეშ შევქმენი ორგანზომილებიანი მასივი,
    რაც აადვილებს კოდის კითხვადობას და ცვლილებებისადმი მოქნილს ხდის. მასივს გადავეცი ერთი მხრივ username და password,
    მეორე მხრივ კი დასაბრუნებელი კოდი და ტექსტი, რომელიც შემდეგ გამოყენებულია უშუალოდ ტესტებში ვალიდაციისთვის.
    ასევე, DataProvider უზრუნველყოფს ერთი მეთოდის ფარგლებში განსხვავებული მნიშვნელობებით ტესტ ქეისების შესრულებას.
     */
    @DataProvider(name = "negativeScenarios")
    static Object[][] negativeScenarios() {
        return new Object[][]{
                {"automation", "Automation@!@123", "1204", "User exists!"},
                {"automation", "Auto@2", "1300", "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer."},
                {"automation", "", "1200", "UserName and Password required."}
        };
    }
}
