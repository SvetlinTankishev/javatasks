import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyWithByteStream {

    public static void copy(String source, String destination) throws IOException {

        try (FileInputStream inputStream = new FileInputStream(source); FileOutputStream outputStream = new FileOutputStream(destination)) {

            int byteRead;
            while ((byteRead = inputStream.read()) != -1) {
                outputStream.write(byteRead);
            }
        }
    }
}