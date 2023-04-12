import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class Main {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date1 = dateFormat.parse(args[0]);
            Date date2 = dateFormat.parse(args[1]);
            long daysBetween = TimeUnit.MILLISECONDS.toDays(Math.abs(date2.getTime() - date1.getTime()));
            System.out.println("Using SimpleDateFormat, days between " + args[0] + " and " + args[1] + " is " + daysBetween);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter dates in dd-MM-yyyy format.");
        }

        try {
            LocalDate date1 = LocalDate.parse(args[0], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalDate date2 = LocalDate.parse(args[1], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            long daysBetween = ChronoUnit.DAYS.between(date1, date2);
            System.out.println("Using LocalDate, days between " + args[0] + " and " + args[1] + " is " + daysBetween);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter dates in dd-MM-yyyy format.");
        }
    }
}
