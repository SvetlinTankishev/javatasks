package FileManager.Operations;

import javax.management.OperationsException;
import java.io.File;

public class CreateEmptyFileOperation extends AbstractOperation {
    @Override
    public void execute(File file) throws OperationsException {
        try {
            if (!file.createNewFile()) {
                throw new OperationsException("Failed to create empty file");
            }
        } catch (Exception e) {
            throw new OperationsException(e.getMessage());
        }
    }
}
