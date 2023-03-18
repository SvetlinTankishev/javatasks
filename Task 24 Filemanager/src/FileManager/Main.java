package FileManager;

import FileManager.Factory.OperationFactory;
import FileManager.Operations.AbstractOperation;

import javax.management.OperationsException;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("test.txt");
        try {
            AbstractOperation createEmptyFileOperation = OperationFactory.createOperation(OperationFactory.CREATE_EMPTY_FILE);
            createEmptyFileOperation.execute(file);

            AbstractOperation deleteFileOperation = OperationFactory.createOperation(OperationFactory.DELETE_FILE);
            deleteFileOperation.execute(file);

            File directory = new File("test");
            AbstractOperation createDirectoryOperation = OperationFactory.createOperation(OperationFactory.CREATE_DIRECTORY);
            createDirectoryOperation.execute(directory);

            if (directory.exists() && directory.isDirectory()) {
                System.out.println("Directory created successfully");
            }
        } catch (OperationsException e) {
            System.err.println(e.getMessage());
        }
    }
}