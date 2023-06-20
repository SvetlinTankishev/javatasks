package backend.filelogger;

import backend.LogBackend;
import backend.config.LogLevel;

public class FileLogger implements LogBackend {
    private final LoggerConfig loggerConfig;

    public FileLogger(String className) {
        loggerConfig = new LoggerConfig(className);
    }

    private void openLogFile(String logPath) {
        // Logic to open the log file
    }

    private void printMessage(LogLevel level, String message, Throwable t) {
        // Logic to print the log message
    }

    @Override
    public boolean isLevelEnabled(LogLevel level) {
        return loggerConfig.isEnabled(level);
    }

    @Override
    public void log(LogLevel level, String message) {
        if (isLevelEnabled(level)) {
            printMessage(level, message, null);
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable throwable) {
        if (isLevelEnabled(level)) {
            printMessage(level, message, throwable);
        }
    }
}
