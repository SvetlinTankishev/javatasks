import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private String loggerName;
    private Level logLevel;
    private String logFile;
    private BufferedWriter writer;

    public enum Level {
        SEVERE,
        WARNING,
        INFO,
        CONFIG,
        FINE,
        FINER,
        FINEST
    }

    public Logger(String loggerName) {
        this.loggerName = loggerName;
        this.logLevel = Level.INFO;
        this.logFile = loggerName + ".log";

        try {
            writer = new BufferedWriter(new FileWriter(logFile, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void severe(String message) {
        severe(message, null);
    }

    public void severe(String message, Throwable t) {
        if (logLevel.ordinal() >= Level.SEVERE.ordinal()) {
            String logMessage = getLogMessage("SEVERE", message, t);
            writeLog(logMessage);
        }
    }

    public void warning(String message) {
        warning(message, null);
    }

    public void warning(String message, Throwable t) {
        if (logLevel.ordinal() >= Level.WARNING.ordinal()) {
            String logMessage = getLogMessage("WARNING", message, t);
            writeLog(logMessage);
        }
    }

    public void info(String message) {
        if (logLevel.ordinal() >= Level.INFO.ordinal()) {
            String logMessage = getLogMessage("INFO", message, null);
            writeLog(logMessage);
        }
    }

    public void config(String message) {
        if (logLevel.ordinal() >= Level.CONFIG.ordinal()) {
            String logMessage = getLogMessage("CONFIG", message, null);
            writeLog(logMessage);
        }
    }

    public void fine(String message) {
        if (logLevel.ordinal() >= Level.FINE.ordinal()) {
            String logMessage = getLogMessage("FINE", message, null);
            writeLog(logMessage);
        }
    }

    public void finer(String message) {
        if (logLevel.ordinal() >= Level.FINER.ordinal()) {
            String logMessage = getLogMessage("FINER", message, null);
            writeLog(logMessage);
        }
    }

    public void finest(String message) {
        if (logLevel.ordinal() >= Level.FINEST.ordinal()) {
            String logMessage = getLogMessage("FINEST", message, null);
            writeLog(logMessage);
        }
    }

    private String getLogMessage(String level, String message, Throwable t) {
        StringBuilder sb = new StringBuilder();
        sb.append(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        sb.append(" [");
        sb.append(loggerName);
        sb.append("] ");
        sb.append(level);
        sb.append(": ");
        sb.append(message);

        if (t != null) {
            sb.append("\n");
            PrintWriter pw = new PrintWriter(sb);
            t.printStackTrace(pw);
            pw.close();
        }

        return sb.toString();
    }

    private void writeLog(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeWriter() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}