import java.io.File;
import java.nio.file.*;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        String directory = args[0];
        String fileName = args[1];
        int maxDepth = Integer.parseInt(args[2]);

        System.out.println("Using recursion:");
        List<String> result1 = new ArrayList<>();
        searchRecursively(new File(directory), fileName, maxDepth, result1);
        printResults(result1);

        System.out.println("\nUsing Files.walk static method:");
        List<String> result2 = new ArrayList<>();
        searchUsingFilesWalk(directory, fileName, maxDepth, result2);
        printResults(result2);

        System.out.println("\nUsing Files.walk static method without lambdas:");
        List<String> result3 = new ArrayList<>();
        searchUsingFilesWalkALT(directory, fileName, maxDepth, result3);
        printResults(result3);

        }
        private static void searchRecursively(File directory, String filename, int maxDepth, List<String> result) {
            if (directory == null || !directory.isDirectory() || maxDepth < 0) {
                return;
            }

            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().equals(filename)) {
                        result.add(file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        searchRecursively(file, filename, maxDepth - 1, result);
                    }
                }
            }
        }

        private static void searchUsingFilesWalk(String directory, String filename, int maxDepth, List<String> result) throws IOException {
            Path start = Paths.get(directory);

            Files.walk(start, maxDepth)
                    .filter(path -> path.toFile().getName().equals(filename)) //LAMBDAS BABYYYY
                    .forEach(path -> result.add(path.toAbsolutePath().toString()));
        }

        private static void searchUsingFilesWalkALT(String directory, String filename, int maxDepth, List<String> result) throws IOException {
            Path start = Paths.get(directory);

            try (Stream<Path> stream = Files.walk(start, maxDepth)) {
                Iterator<Path> iterator = stream.iterator();
                while (iterator.hasNext()) {
                    Path path = iterator.next();
                    if (path.toFile().getName().equals(filename)) {
                        result.add(path.toAbsolutePath().toString());
                    }
                }
            }
        }

        private static void printResults(List<String> result) {

            if (result.isEmpty()) {
                System.out.println("No matches found.");
            } else {
                System.out.println("Found " + result.size() + " matches:");
                for (String path : result) {
                    System.out.println(path);
                }
            }
        }


}