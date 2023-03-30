import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        LOGGER.setLevel(Level.WARNING);

        LOGGER.severe("This is a severe message.");
        LOGGER.warning("This is a warning message.");
        LOGGER.info("This is an info message.");
        LOGGER.config("This is a config message.");
        LOGGER.fine("This is a fine message.");
        LOGGER.finer("This is a finer message.");
        LOGGER.finest("This is a finest message.");

        try {
            int i = 1/0;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An exception occurred.", e);
        }
    }
}