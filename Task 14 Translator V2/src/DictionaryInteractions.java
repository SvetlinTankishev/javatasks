import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DictionaryInteractions {

    public static final String DICTIONARY_FILE = "dictionary.properties";

    public static Properties loadDictionaryFromFile() {
        Properties dictionary = new Properties();
        try (FileInputStream inputStream = new FileInputStream(DICTIONARY_FILE)) {
            dictionary.load(inputStream);
        } catch (IOException e) {
            System.out.println("Error loading dictionary file: " + e.getMessage());
        }
        return dictionary;
    }

    public static void saveDictionaryToFile(Properties dictionary) {
        try (FileOutputStream outputStream = new FileOutputStream(DICTIONARY_FILE)) {
            dictionary.store(outputStream, "English-Bulgarian dictionary");
        } catch (IOException e) {
            System.out.println("Error saving dictionary file: " + e.getMessage());
        }
    }
}
