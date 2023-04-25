import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileCopyWithFileChannel {
    public static void copy(String source, String destination) throws IOException {
        try (FileChannel input = new FileInputStream(source).getChannel();
             FileChannel output = new FileOutputStream(destination).getChannel()) {
            output.transferFrom(input, 0, input.size());
        }
    }
}


