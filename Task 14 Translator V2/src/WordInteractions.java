import java.util.Properties;
import java.util.Scanner;

public class WordInteractions {
    public static void addEnglishWordToDictionary(Properties dictionary, Scanner scanner) {
        System.out.println("\nEnter a new word in English:");
        String englishWord = scanner.nextLine();

        System.out.println("Enter its Bulgarian translation:");
        String bulgarianWord = scanner.nextLine();

        dictionary.setProperty(englishWord, bulgarianWord);
        dictionary.setProperty(bulgarianWord, englishWord);
        System.out.println("Word added to dictionary.");
    }

    public static void addBulgarianWordToDictionary(Properties dictionary, Scanner scanner) {
        System.out.println("\nДобави нова дума на Български език:");
        String bulgarianWord = scanner.nextLine();

        System.out.println("\nВъведи Английският превод:");
        String englishWord = scanner.nextLine();

        dictionary.setProperty(bulgarianWord, englishWord);
        dictionary.setProperty(englishWord, bulgarianWord);
        System.out.println("Думата е добавена в речникът.");
    }

    public static void translateEnglishWord(Properties dictionary, Scanner scanner) {
        System.out.println("\nEnter an English word to translate:");
        String englishWord = scanner.nextLine();

        String bulgarianWord = dictionary.getProperty(englishWord);
        if (bulgarianWord != null) {
            System.out.println("Translation: " + bulgarianWord);
        } else {
            System.out.println("Word not found in dictionary.");
        }
    }

    public static void translateBulgarianWord(Properties dictionary, Scanner scanner) {
        System.out.println("\nВъведи Българска дума за превод:");
        String bulgarianWord = scanner.nextLine();

        String englishWord = dictionary.getProperty(bulgarianWord);
        if (englishWord != null) {
            System.out.println("Превод: " + englishWord);
        } else {
            System.out.println("Думата не е налична в речникът.");
        }
    }

    public static void englishWordMethod(Properties dictionary, Scanner scanner) {
        while (true) {
            System.out.println("\nPlease chose an option:");
            System.out.println("1. Add new word");
            System.out.println("2. Translate word");
            System.out.println("3. Return to language selection.");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> WordInteractions.addEnglishWordToDictionary(dictionary, scanner);
                case 2 -> WordInteractions.translateEnglishWord(dictionary, scanner);
                case 3 -> {
                    DictionaryInteractions.saveDictionaryToFile(dictionary);
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void bulgarianWordMethod(Properties dictionary, Scanner scanner) {
        while (true) {
            System.out.println("\nИзбор на опция:");
            System.out.println("1. Добавяне на дума");
            System.out.println("2. Превод на дума");
            System.out.println("3. Обратно към избор на език.");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> WordInteractions.addBulgarianWordToDictionary(dictionary, scanner);
                case 2 -> WordInteractions.translateBulgarianWord(dictionary, scanner);
                case 3 -> {
                    DictionaryInteractions.saveDictionaryToFile(dictionary);
                    System.out.println("Довиждане!");
                    return;
                }
                default -> System.out.println("Невалиден избор!");
            }
        }
    }
}
