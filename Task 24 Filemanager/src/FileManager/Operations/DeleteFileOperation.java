package FileManager.Operations;

import javax.management.OperationsException;
import java.io.File;

public class DeleteFileOperation extends AbstractOperation {
    @Override
    public void execute(File file) throws OperationsException {
        try {
            if (!file.delete()) {
                throw new OperationsException("Failed to delete file");
            }
        } catch (Exception e) {
            throw new OperationsException(e.getMessage());
        }
    }
}
