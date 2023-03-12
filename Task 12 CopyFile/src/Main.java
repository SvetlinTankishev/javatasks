import java.io.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.time.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String sourceFile = args[0];
        String destinationFile = args[1];

        System.out.println("Copying file using FileInputStream and FileOutputStream...");
        Instant start = Instant.now();
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(sourceFile);
            out = new FileOutputStream(destinationFile);
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
        Instant end = Instant.now();
        System.out.println("Time taken: " + Duration.between(start, end).toMillis() + " ms");

        System.out.println("Copying file using BufferedInputStream and BufferedOutputStream...");
        start = Instant.now();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(sourceFile));
            bos = new BufferedOutputStream(new FileOutputStream(destinationFile));
            byte[] buffer = new byte[8192];
            int count;
            while ((count = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, count);
            }
        } finally {
            if (bis != null) bis.close();
            if (bos != null) bos.close();
        }
        end = Instant.now();
        System.out.println("Time taken: " + Duration.between(start, end).toMillis() + " ms");

        System.out.println("Copying file using FileChannel class...");
        start = Instant.now();
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(sourceFile).getChannel();
            destChannel = new FileOutputStream(destinationFile).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } finally {
            if (sourceChannel != null) sourceChannel.close();
            if (destChannel != null) destChannel.close();
        }
        end = Instant.now();
        System.out.println("Time taken: " + Duration.between(start, end).toMillis() + " ms");

        System.out.println("Copying file using Files.copy static method...");
        start = Instant.now();
        Files.copy(Paths.get(sourceFile), Paths.get(destinationFile), StandardCopyOption.REPLACE_EXISTING);
        end = Instant.now();
        System.out.println("Time taken: " + Duration.between(start, end).toMillis() + " ms");
    }
}