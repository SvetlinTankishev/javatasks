package FileManager.Operations;

import javax.management.OperationsException;
import java.io.File;

public abstract class AbstractOperation {
    public abstract void execute(File file) throws OperationsException;
    }

