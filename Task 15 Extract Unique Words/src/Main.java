import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Please provide a file name as an argument.");
            return;
        }

        String fileName = args[0];
        Set<String> uniqueWords = new HashSet<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.useDelimiter("[\\s.,:;?!]+");

            while (scanner.hasNext()) {
                uniqueWords.add(scanner.next().toLowerCase());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("Unique words in the file:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }
}