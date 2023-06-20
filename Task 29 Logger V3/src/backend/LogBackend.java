package backend;

import backend.config.LogLevel;

public interface LogBackend {
    boolean isLevelEnabled(LogLevel level);
    void log(LogLevel level, String message);
    void log(LogLevel level, String message, Throwable throwable);
}
