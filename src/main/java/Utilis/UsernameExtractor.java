package Utilis;

public interface UsernameExtractor {
    /*
    UsernameExtractor ინტერფეისში შექმნილია მეთოდი extractValueFromResponse,
    რომელიც იღებს ორ პარამეტრს Request-ის შედეგად დაბრუნებულ response-ს და
    key-ს. მეთოდი key-ს საკვანძო სიტყვაზე დაყრდნობით response-დან იღებს სასურველ მნიშვნელობას,
    რომელიც შემდგომში გამოიყენება ვალიდაციების დროს. მაგ. დაბრუნებული პასუხიდან
    ეს მეთოდი შესაძლებელს ხდის ამოვიღოთ username, userId, ან სხვა სასურველი მნიშვნელობა.
     */
    default String extractValueFromResponse(String response, String key) {
        int startIndex = response.indexOf("\"" + key + "\":") + key.length() + 3;
        int endIndex = response.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = response.indexOf("}", startIndex);
        }
        return response.substring(startIndex, endIndex).replace("\"", "").trim();
    }
}
