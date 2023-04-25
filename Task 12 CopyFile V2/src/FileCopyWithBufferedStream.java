import java.io.*;

public class FileCopyWithBufferedStream {
    public static void copy(String source, String destination) throws IOException {

        try (InputStream inputStream = new BufferedInputStream (new FileInputStream(source));
             OutputStream outputStream = new BufferedOutputStream (new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
