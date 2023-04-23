import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        String date1 = args[0];
        String date2 = args[1];

        long days1 = 0;
        long days2 = 0;

        try {
            days1 = DateCalculatorUsingSimpleDateFormat.calculateDaysBetween(date1, date2); //tl;dr: old bad
            days2 = DateCalculatorUsingLocalDate.calculateDaysBetween(date1, date2); //tl;dr: new good
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Number of days between " + date1 + " and " + date2 + " using SimpleDateFormat, Date and TimeUnit: " + days1);
        System.out.println("Number of days between " + date1 + " and " + date2 + " using LocalDate and ChronoUnit " + days2);
    }
}