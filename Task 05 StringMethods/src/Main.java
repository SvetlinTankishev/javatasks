import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String text = "And if you ask me how I'm feeling. Don't tell me you're too blind to see. Never gonna give you up. Never gonna let you down. Never gonna run around and desert you. Never gonna mek you cry. Never gonna say goodbye. Never gonna tell a lie and hurt you.";

        int capitalACount = countCapitalAs(text);
        String reversedText = reverseText(text);
        String replacedText = replaceAsWithAAs(text);
        String[] words = splitTextIntoWords(text);

        System.out.println("Original Text: " + text);
        System.out.println("Number of capital A in text: " + capitalACount);
        System.out.println("Reversed text: " + reversedText);
        System.out.println("Replace A with AA: " + replacedText);
        System.out.println("Words in text: " + Arrays.toString(words));
    }

    public static int countCapitalAs(String text) {
        return text.length() - text.replaceAll("A", "").length();
    }

    public static String reverseText(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    public static String replaceAsWithAAs(String text) {
        return text.replaceAll("A", "AA");
    }

    public static String[] splitTextIntoWords(String text) {
        return text.split("\\W+");
    }

}