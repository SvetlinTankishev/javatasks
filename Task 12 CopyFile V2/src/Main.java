import java.io.*;

public class Main {
    public static void main(String[] args) {
        String sourceFile = args[0];
        String destinationFile = args[1];

        // Using Files.copy static method
        long timeTaken = MeasureTime.measureTime(() -> {
            try {
                FileCopyWithFilesCopy.copy(sourceFile, destinationFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.printf("Time taken by Files.copy: %d ms%n%n", timeTaken);


        // Using BufferedInputStream and BufferedOutputStream
        timeTaken = MeasureTime.measureTime(() -> {
            try {
                FileCopyWithBufferedStream.copy(sourceFile, destinationFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.printf("Time taken by buffered stream: %d ms%n%n", timeTaken);

        // Using FileChannel class
        timeTaken = MeasureTime.measureTime(() -> {
            try {
                FileCopyWithFileChannel.copy(sourceFile, destinationFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.printf("Time taken by file channel: %d ms%n%n", timeTaken);

        // Using ByteStream
        timeTaken = MeasureTime.measureTime(() -> {
            try {
                FileCopyWithByteStream.copy(sourceFile, destinationFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.printf("Time taken by byte stream: %d ms%n%n", timeTaken);
    }
}
