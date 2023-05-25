import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class PunchCardManager {
    private static final String FILE_NAME = "clock_in_out.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

    public void clockIn() {
        Date date = new Date();
        String dateTime = DATE_FORMAT.format(date);

        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);
            writer.write("Clock In: " + dateTime + "\n");
            writer.close();
            showOptionDialog("You have clocked in at " + dateTime, "Clock In");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void clockOut() {
        Date date = new Date();
        String dateTime = DATE_FORMAT.format(date);

        String clockInTimestamp = readLastClockInTimestamp();

        long diffInMinutes = calculateTimeDifference(clockInTimestamp, dateTime);

        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);
            writer.write("Clock Out: " + dateTime + "\n");
            writer.write("Time spent: " + diffInMinutes + " minutes\n\n");
            writer.close();
            showOptionDialog("You have clocked out at " + dateTime + " (" + diffInMinutes + " minutes)", "Clock Out");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String readLastClockInTimestamp() {
        String clockInTimestamp = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Clock In:")) {
                    clockInTimestamp = line.substring(10);
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return clockInTimestamp;
    }

    private long calculateTimeDifference(String startTime, String endTime) {
        long diffInMillies = 0;
        try {
            Date clockInDate = DATE_FORMAT.parse(startTime);
            Date clockOutDate = DATE_FORMAT.parse(endTime);
            diffInMillies = Math.abs(clockOutDate.getTime() - clockInDate.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return TimeUnit.MILLISECONDS.toMinutes(diffInMillies);
    }

    public void openPunchCardFile() {
        JPasswordField passwordField = new JPasswordField();
        int input = JOptionPane.showConfirmDialog(null, passwordField, "Enter Password:", JOptionPane.OK_CANCEL_OPTION);

        if (input == JOptionPane.OK_OPTION) {
            String password = new String(passwordField.getPassword());
            if (password.equals("123")) {
                try {
                    Desktop.getDesktop().open(new File(FILE_NAME));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect password. Access denied.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void showTotalWorkTime() {
        ArrayList<Long> timeSpentValues = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Time spent:")) {
                    String timeSpentString = line.substring(12, line.indexOf(" minutes"));
                    timeSpentValues.add(Long.parseLong(timeSpentString));
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        long totalWorkTime = 0;
        for (long timeSpent : timeSpentValues) {
            totalWorkTime += timeSpent;
        }

        long hours = TimeUnit.MINUTES.toHours(totalWorkTime);
        long minutes = TimeUnit.MINUTES.toMinutes(totalWorkTime) - TimeUnit.HOURS.toMinutes(hours);
        long seconds = TimeUnit.MINUTES.toSeconds(totalWorkTime) - TimeUnit.HOURS.toSeconds(hours) - TimeUnit.MINUTES.toSeconds(minutes);

        String totalWorkTimeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        showOptionDialog("Total work time: " + totalWorkTimeString, "Work Total");
    }

    private void showOptionDialog(String message, String title) {
        JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"OK"}, null);
    }


}