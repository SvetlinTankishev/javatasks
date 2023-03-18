package FileManager.Operations;

import javax.management.OperationsException;
import java.io.File;

public class CreateDirectoryOperation extends AbstractOperation {
    @Override
    public void execute(File file) throws OperationsException {
        try {
            if (!file.mkdir()) {
                throw new OperationsException("Failed to create directory");
            }
        } catch (Exception e) {
            throw new OperationsException(e.getMessage());
        }
    }
}
