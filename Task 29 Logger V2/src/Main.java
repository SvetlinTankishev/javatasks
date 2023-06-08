public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();

        logger.warning("This is a warning message");
        logger.severe("This is a severe message", new Exception("Exception details"));
        logger.info("This is an info message");

        try {
            throw new RuntimeException("This is an example exception");
        } catch (Exception e) {
            logger.warning("An exception occurred", e);
        }
    }
}
