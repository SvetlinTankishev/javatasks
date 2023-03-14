import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length != 4) {
            System.out.println("Usage: java Main <source file> <target file> <word to replace> <new word>");
            System.exit(1);
        }

        String sourceFile = args[0];
        String targetFile = args[1];
        String wordToReplace = args[2];
        String newWord = args[3];

        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile));

        String line;
        while ((line = reader.readLine()) != null) {
            line = line.replaceAll(wordToReplace, newWord);
            writer.write(line);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}