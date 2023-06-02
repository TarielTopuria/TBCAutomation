package DataPackage;

import org.testng.annotations.DataProvider;

public interface CreateUserPositiveTestData {
    /*
    CreateUserPositiveTestData ინტერფეისის ქვეშ შევქმენი uniqueUser String ტიპის ცვლადი,
    რომელსაც ჰარდად მივანიჭე სახელი uniqueUser და კონკატენაციით მივაბი currentTimeMillis, რაც
    უზრუნველყოფს ამ სახელის მუდმივ ინდივიდუალურობას, რადგან დამოკიდებული იქნება დროზე.
    ასევე, აქ შესაძლებელი იყო ნებისმიერი სხვა რამის გამოყენება, მაგალითად რენდომაიზერის.
    ასევე, ინტერფეისის ქვეშ შევქმენი DataProvider, რომელსაც ამ ეტაპზე გადაცემული აქვს მხოლოდ ერთი key-value
    მნიშვნელობები, მაგრამ ის შესაძლებლობას იძლევა სასურველ დროს მხოლოდ ამ ნაწილში ცვლილებებით დაემატოს
    შესამოწმებელი მნიშვნელობები, რაც კოდს ხდის მარტივს და მარტივად ცვალებადს.
     */
    String uniqueUser = "uniqueUser" + System.currentTimeMillis();

    @DataProvider(name = "createUserPositiveScenarios")
    static Object[][] positiveScenarios() {
        return new Object[][]{
                {uniqueUser, "Automation@!@123"}
        };
    }
}
