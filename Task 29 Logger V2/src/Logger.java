import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.logging.*;

public class Logger {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());
    private static Level logLevel;
    private static String logFile;

    static {
        try {
            InputStream inputStream = Logger.class.getClassLoader().getResourceAsStream("config.properties");
            if (inputStream == null) {
                throw new FileNotFoundException("config.properties file not found in the classpath");
            }
            Properties properties = new Properties();
            properties.load(inputStream);
            logLevel = Level.parse(properties.getProperty("log.level", "WARNING"));
            logFile = properties.getProperty("log.file", "logger.log");
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Error loading properties file: " + e.getMessage() + ", using default values");
            logLevel = Level.WARNING;
            logFile = "logger.log";
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading properties file, using default values", e);
            logLevel = Level.WARNING;
            logFile = "logger.log";
        }
    }

    public void severe(String message) {
        log(Level.SEVERE, message, null);
    }

    public void severe(String message, Throwable t) {
        log(Level.SEVERE, message, t);
    }

    public void warning(String message) {
        log(Level.WARNING, message, null);
    }

    public void warning(String message, Throwable t) {
        log(Level.WARNING, message, t);
    }

    public void info(String message) {
        log(Level.INFO, message, null);
    }

    public void config(String message) {
        log(Level.CONFIG, message, null);
    }

    public void fine(String message) {
        log(Level.FINE, message, null);
    }

    public void finer(String message) {
        log(Level.FINER, message, null);
    }

    public void finest(String message) {
        log(Level.FINEST, message, null);
    }

    private void log(Level level, String message, Throwable t) {
        if (level.intValue() >= logLevel.intValue()) {
            try {
                FileHandler fileHandler = new FileHandler(logFile, true);
                fileHandler.setFormatter(new Formatter() {
                    @Override
                    public String format(LogRecord record) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(new Date(record.getMillis())).append(" : ");
                        builder.append(record.getLevel()).append(" : ");
                        builder.append(record.getSourceClassName()).append(" : ");
                        builder.append(record.getSourceMethodName()).append(" : ");
                        builder.append(record.getMessage());
                        if (record.getThrown() != null) {
                            builder.append(" : ").append(record.getThrown());
                        }
                        return builder.append("\n").toString();
                    }
                });
                logger.addHandler(fileHandler);
                logger.log(level, message, t);
                logger.removeHandler(fileHandler);
                fileHandler.close();
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Error logging message", e);
            }
        }
    }
}
