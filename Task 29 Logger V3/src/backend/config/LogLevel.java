package backend.config;

public enum LogLevel {
    OFF(Integer.MAX_VALUE),
    SEVERE(1000),
    WARNING(900),
    INFO(800),
    CONFIG(700),
    FINE(500),
    FINER(400),
    FINEST(300),
    ALL(Integer.MIN_VALUE);

    private final int intValue;

    LogLevel(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public boolean isEnabled(LogLevel otherLevel) {
        return this.intValue <= otherLevel.intValue;
    }

    public static LogLevel getIntLevel(String className) {
        // Logic to determine the log level based on the class name
        // Example: Mapping specific class names to log levels
        if (className.contains("com.example.package1")) {
            return LogLevel.INFO;
        } else if (className.contains("com.example.package2")) {
            return LogLevel.WARNING;
        }
        // Add more mappings as needed
        // Default log level if no mapping found
        return LogLevel.INFO;
    }
}
