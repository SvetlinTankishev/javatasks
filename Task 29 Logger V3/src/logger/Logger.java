package logger;

import backend.LogBackend;
import backend.LogBackendFactory;
import backend.filelogger.FileLogger;

public class Logger implements LogBackendFactory {
    private static final Logger instance = new Logger();

    public static Logger getInstance() {
        return instance;
    }

    private Logger() {
        // Private constructor to enforce singleton pattern
    }

    public LogBackend getLogger(String className) {
        return createLogBackend(className);
    }

    @Override
    public LogBackend createLogBackend(String classLabel) {
        return new FileLogger(classLabel);
    }
}
