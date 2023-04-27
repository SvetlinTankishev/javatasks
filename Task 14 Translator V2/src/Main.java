import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Properties dictionary = DictionaryInteractions.loadDictionaryFromFile();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select language/Избор на език");
            System.out.println("1. English");
            System.out.println("2. Български");
            System.out.println("3. Exit!/Изход!");

            int languageSelection = scanner.nextInt();
            scanner.nextLine();

            switch (languageSelection) {
                case 1 -> WordInteractions.englishWordMethod(dictionary, scanner);
                case 2 -> WordInteractions.bulgarianWordMethod(dictionary, scanner);
                case 3 -> {
                    System.out.println("Goodbye!\nДовиждане!");
                    return;
                }
                default -> System.out.println("Invalid choice!\nНевалиден избор!");
            }
        }
    }
}