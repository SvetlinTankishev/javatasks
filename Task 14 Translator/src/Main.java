import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private static final String DICTIONARY_FILE = "dictionary.properties";

    public static void main(String[] args) {
        Properties dictionary = loadDictionaryFromFile();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPlease chose an option:");
            System.out.println("1. Add new word");
            System.out.println("2. Translate word");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addNewWord(dictionary, scanner);
                case 2 -> translateWord(dictionary, scanner);
                case 3 -> {
                    saveDictionaryToFile(dictionary);
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static Properties loadDictionaryFromFile() {
        Properties dictionary = new Properties();
        try (FileInputStream inputStream = new FileInputStream(DICTIONARY_FILE)) {
            dictionary.load(inputStream);
        } catch (IOException e) {
            System.out.println("Error loading dictionary file: " + e.getMessage());
        }
        return dictionary;
    }

    private static void saveDictionaryToFile(Properties dictionary) {
        try (FileOutputStream outputStream = new FileOutputStream(DICTIONARY_FILE)) {
            dictionary.store(outputStream, "English-Bulgarian dictionary");
        } catch (IOException e) {
            System.out.println("Error saving dictionary file: " + e.getMessage());
        }
    }

    private static void addNewWord(Properties dictionary, Scanner scanner) {
        System.out.println("\nEnter a new word in English:");
        String englishWord = scanner.nextLine();

        System.out.println("Enter its Bulgarian translation:");
        String bulgarianWord = scanner.nextLine();

        dictionary.setProperty(englishWord, bulgarianWord);
        System.out.println("Word added to dictionary.");
    }

    private static void translateWord(Properties dictionary, Scanner scanner) {
        System.out.println("\nEnter an English word to translate:");
        String englishWord = scanner.nextLine();

        String bulgarianWord = dictionary.getProperty(englishWord);
        if (bulgarianWord != null) {
            System.out.println("Translation: " + bulgarianWord);
        } else {
            System.out.println("Word not found in dictionary.");
        }
    }

}