import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String filePath = "text.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder textBuilder = new StringBuilder();
            String line;
            while ((line=reader.readLine()) != null) {
                textBuilder.append(line).append("\n");
            }

            String text = textBuilder.toString();

            Pattern emailPattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");
            Matcher emailMatcher = emailPattern.matcher(text);


            StringBuilder resultBuilder = new StringBuilder();
            while (emailMatcher.find()) {
                resultBuilder.append(emailMatcher.group()).append(", ");
            }
            String result = resultBuilder.toString().trim();
            if (result.endsWith(", ")) {
                result = result.substring(0, result.length() - 1);
            }

            System.out.println(result);
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}