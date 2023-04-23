import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateCalculatorUsingLocalDate {
    public static long  calculateDaysBetween(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate ld1 = LocalDate.parse(date1, formatter);
        LocalDate ld2 = LocalDate.parse(date2, formatter);

        long diff = ChronoUnit.DAYS.between(ld1, ld2);

        return diff;
    }
}
