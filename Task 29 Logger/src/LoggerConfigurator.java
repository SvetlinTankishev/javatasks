import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoggerConfigurator {

    private String propertiesFile;
    private Properties properties;

    public LoggerConfigurator(String propertiesFile) throws LoggerConfigurationException {
        this.propertiesFile = propertiesFile;
        this.properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(propertiesFile);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new LoggerConfigurationException("Error loading properties file", e);
        }
    }

    public Level getLogLevel() {
        String level = properties.getProperty("log.level", "INFO");
        return Level.valueOf(level.toUpperCase());
    }

    public String getLogFile() {
        return properties.getProperty("log.file", "log.txt");
    }
}