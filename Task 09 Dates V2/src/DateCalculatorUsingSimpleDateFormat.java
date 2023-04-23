import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;
/*
 Mutable, not thread-safe and having some design issues.
 Verbose, requires converting date strings to date objects, then calculating difference in milliseconds and conversing those milliseconds to days.
 Throws ParseException if date is not in the expected format which needs try-catch block.
 Can find use with legacy code or if needed to interact with external systems that use old Date and SimpleDateFormat classes.
*/
public class DateCalculatorUsingSimpleDateFormat { //mutable, not thread-safe and having some design issues.
    public static long calculateDaysBetween(String date1, String date2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date d1 = sdf.parse(date1);
        Date d2 = sdf.parse(date2);

        long diffInMillies = Math.abs(d2.getTime() - d1.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return diff;
    }
}
