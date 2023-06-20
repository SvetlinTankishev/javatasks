package test;

import backend.LogBackend;
import backend.config.LogLevel;
import logger.Logger;

public class LoggerTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Logger logger = Logger.getInstance();
        LogBackend backend = logger.getLogger(LoggerTest.class.getName());

        backend.log(LogLevel.INFO, "This is an info message");
        backend.log(LogLevel.WARNING, "This is a warning message");
        backend.log(LogLevel.SEVERE, "This is a severe message");
    }
}
