import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyWithFilesCopy {
    public static void copy(String source, String destination) throws IOException {
        Path sourcePath = Paths.get(source);
        Path destinationPath = Paths.get(destination);
        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

    }
}
