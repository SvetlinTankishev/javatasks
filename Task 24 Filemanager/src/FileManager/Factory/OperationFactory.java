package FileManager.Factory;


import FileManager.Operations.AbstractOperation;
import FileManager.Operations.CreateDirectoryOperation;
import FileManager.Operations.CreateEmptyFileOperation;
import FileManager.Operations.DeleteFileOperation;

import javax.management.OperationsException;

public class OperationFactory {
    public static final int CREATE_EMPTY_FILE = 1;
    public static final int DELETE_FILE = 2;
    public static final int CREATE_DIRECTORY = 3;

    public static AbstractOperation createOperation(int operationType) throws OperationsException {
        return switch (operationType) {
            case CREATE_EMPTY_FILE -> new CreateEmptyFileOperation();
            case DELETE_FILE -> new DeleteFileOperation();
            case CREATE_DIRECTORY -> new CreateDirectoryOperation();
            default -> throw new OperationsException("Invalid operation type");
        };
    }
}
