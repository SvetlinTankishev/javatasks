import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date1 = sdf.parse(args[0]);
        Date date2 = sdf.parse(args[1]);

        long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
        long diffUsingSimpleDateFormat = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        LocalDate localDate1 = LocalDate.parse(args[0], DateTimeFormatter.ofPattern(dateFormat));
        LocalDate localDate2 = LocalDate.parse(args[1], DateTimeFormatter.ofPattern(dateFormat));

        long diffUsingLocalDate = ChronoUnit.DAYS.between(localDate1, localDate2);

        System.out.println("Difference in days between " + args[0] + " and " + args[1] + " using SimpleDateFormat is " + diffUsingSimpleDateFormat);
        System.out.println("Difference in days between " + args[0] + " and " + args[1] + " using LocalDate: " + diffUsingLocalDate);
        System.out.printf("Using SimpleDateFormat, Date and TimeUnit classes the difference between %s and %s is %d day.%n", args[0], args[1], diffUsingSimpleDateFormat);
        System.out.printf("Using LocalDate and ChronoUnit classes, the difference between %s and %s is %d days.%n", localDate1, localDate2, diffUsingLocalDate);
    }
}
