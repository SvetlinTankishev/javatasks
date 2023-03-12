import java.io.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        String sourceFile = args[0];
        String destinationFile = args[1];

        System.out.println("Copying file using FileInputStream and FileOutputStream...");
        long timeTaken = measureTime(() -> {
            try {
                copyFileUsingStreams(sourceFile, destinationFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.printf("Time taken: %d ms%n%n", timeTaken);

        System.out.println("Copying file using BufferedInputStream and BufferedOutputStream...");
        timeTaken = measureTime(() -> {
            try {
                copyFileUsingBufferedStreams(sourceFile, destinationFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.printf("Time taken: %d ms%n%n", timeTaken);

        System.out.println("Copying file using FileChannel class...");
        timeTaken = measureTime(() -> {
            try {
                copyFileUsingChannels(sourceFile, destinationFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.printf("Time taken: %d ms%n%n", timeTaken);

        System.out.println("Copying file using Files.copy static method...");
        timeTaken = measureTime(() -> {
            try {
                copyFileUsingFilesCopy(sourceFile, destinationFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.printf("Time taken: %d ms%n%n", timeTaken);
    }

    private static long measureTime(Runnable action) {
        Instant start = Instant.now();
        try {
            action.run();
        } finally {
            Instant end = Instant.now();
            return Duration.between(start, end).toMillis();
        }
    }

    private static void copyFileUsingStreams(String sourceFile, String destinationFile) throws IOException {
        try (InputStream in = new FileInputStream(sourceFile);
             OutputStream out = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[8192];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

    private static void copyFileUsingBufferedStreams(String sourceFile, String destinationFile) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(sourceFile));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
            byte[] buffer = new byte[8192];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

    private static void copyFileUsingChannels(String sourceFile, String destinationFile) throws IOException {
        try (FileChannel in = new FileInputStream(sourceFile).getChannel();
             FileChannel out = new FileOutputStream(destinationFile).getChannel()) {
            out.transferFrom(in, 0, in.size());
        }
    }

    private static void copyFileUsingFilesCopy(String sourceFile, String destinationFile) throws IOException {
        Files.copy(Paths.get(sourceFile), Paths.get(destinationFile), StandardCopyOption.REPLACE_EXISTING);
    }
}
