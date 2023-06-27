import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PunchCardManager {
    private static final String FILE_NAME = "clock_in_out.txt";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
    private final Properties properties;

    public PunchCardManager() {
        properties = loadProperties();
    }

    public void clockIn() {
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(DATE_FORMAT);

        try {
            Files.writeString(Path.of(FILE_NAME), "Clock In: " + formattedDateTime + "\n", StandardOpenOption.APPEND);
            showOptionDialog("You have clocked in at " + formattedDateTime, "Clock In");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void clockOut() {
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(DATE_FORMAT);

        LocalDateTime clockInDateTime = readLastClockInTimestamp();

        Duration duration = calculateTimeDifference(clockInDateTime, dateTime);

        try {
            Path of = Path.of(FILE_NAME);
            Files.writeString(of, "Clock Out: " + formattedDateTime + "\n", StandardOpenOption.APPEND);
            Files.writeString(of, "Time spent: " + duration.toMinutes() + " minutes\n\n", StandardOpenOption.APPEND);
            showOptionDialog("You have clocked out at " + formattedDateTime + " (" + duration.toMinutes() + " minutes)", "Clock Out");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private LocalDateTime readLastClockInTimestamp() {
        LocalDateTime clockInTimestamp = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Clock In:")) {
                    String timestampString = line.substring(10);
                    clockInTimestamp = LocalDateTime.parse(timestampString, DATE_FORMAT);
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return clockInTimestamp;
    }

    private Duration calculateTimeDifference(LocalDateTime startTime, LocalDateTime endTime) {
        return Duration.between(startTime, endTime);
    }

    public void openPunchCardFile() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        int input = JOptionPane.showConfirmDialog(
                null,
                passwordField,
                "Enter Password:",
                JOptionPane.OK_CANCEL_OPTION);

        if (input == JOptionPane.OK_OPTION) {
            String password = new String(passwordField.getPassword());
            String storedPassword = properties.getProperty("password");

            if (password.equals(storedPassword)) {
                try {
                    Desktop.getDesktop().open(new File(FILE_NAME));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Incorrect password. Access denied.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Properties loadProperties() {
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream("config.properties")) {
            properties.load(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    private void saveProperties(Properties properties) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("config.properties")) {
            properties.store(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8), null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void changePassword() {
        File configFile = new File("config.properties");

        if (!configFile.exists()) {
            createConfigPropertiesFile();
        } else {
            changeExistingPassword();
        }
    }

    public void createConfigPropertiesFile() {
        try {
            File configFile = new File("config.properties");
            boolean created = configFile.createNewFile();

            if (created) {
                JPasswordField passwordField = new JPasswordField();
                passwordField.setEchoChar('*');

                JPanel panel = new JPanel(new GridLayout(2, 1));
                panel.add(new JLabel("Enter password:"));
                panel.add(passwordField);

                int option = JOptionPane.showOptionDialog(
                        null,
                        panel,
                        "Set Password",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        null);

                if (option == JOptionPane.OK_OPTION) {
                    String newPassword = new String(passwordField.getPassword());

                    properties.setProperty("password", newPassword.trim());
                    saveProperties(properties);

                    JOptionPane.showMessageDialog(
                            null,
                            "Password set successfully!",
                            "Set Password",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (configFile.delete()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Configuration file creation canceled. The empty config file has been deleted.",
                                "Canceled",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Failed to delete the empty config file.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Failed to create the password file.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeExistingPassword() {
        JPasswordField previousPasswordField = new JPasswordField();
        previousPasswordField.setEchoChar('*');

        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("Enter previous password:"));
        panel.add(previousPasswordField);

        if (JOptionPane.showOptionDialog(
                null,
                panel,
                "Change Password",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null) == JOptionPane.OK_OPTION) {

            String previousPassword = new String(previousPasswordField.getPassword());
            String storedPassword = properties.getProperty("password");

            if (previousPassword.equals(storedPassword)) {
                JPasswordField newPasswordField = new JPasswordField();
                newPasswordField.setEchoChar('*');

                panel.removeAll();
                panel.add(new JLabel("Enter new password:"));
                panel.add(newPasswordField);

                if (JOptionPane.showOptionDialog(
                        null,
                        panel,
                        "Change Password",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        null) == JOptionPane.OK_OPTION) {

                    String newPassword = new String(newPasswordField.getPassword());

                    if (newPassword.equals(previousPassword)) {
                        JOptionPane.showMessageDialog(
                                null,
                                "New password must be different from the previous password. Change password failed.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        properties.setProperty("password", newPassword.trim());
                        saveProperties(properties);

                        JOptionPane.showMessageDialog(
                                null,
                                "Password changed successfully!",
                                "Change Password",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Incorrect password. Change password failed.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void showTotalWorkTime() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            long totalWorkTime = 0;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Time spent:")) {
                    String timeSpent = line.substring(12, line.indexOf(" minutes"));
                    totalWorkTime += Long.parseLong(timeSpent);
                }
            }
            reader.close();

            long hours = TimeUnit.MINUTES.toHours(totalWorkTime);
            long minutes = totalWorkTime - TimeUnit.HOURS.toMinutes(hours);

            JOptionPane.showMessageDialog(
                    null,
                    "Total work time: " + hours + " hours, " + minutes + " minutes",
                    "Total Work Time",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void showOptionDialog(String message, String title) {
        JOptionPane.showOptionDialog(
                null,
                message,
                title,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{},
                null);
    }
}
