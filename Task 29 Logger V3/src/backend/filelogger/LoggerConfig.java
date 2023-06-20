package backend.filelogger;

import backend.config.LogLevel;

public class LoggerConfig {
    private final LogLevel logLevel;

    public LoggerConfig(String className) {
        // Logic to load the log level configuration based on the class name
        logLevel = LogLevel.getIntLevel(className);
    }

    public boolean isEnabled(LogLevel otherLevel) {
        return logLevel.isEnabled(otherLevel);
    }
}
