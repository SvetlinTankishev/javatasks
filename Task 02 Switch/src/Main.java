public class Main {
    public static void main(String[] args) {
        int day = 1;
        String dayOfWeek = verifyDay(day);
        System.out.println("Day of the week is: " + dayOfWeek);
        day = 5;
        dayOfWeek = verifyDay(day);
        System.out.println("Verifying that the number " + day + " is " + dayOfWeek + " of the week.");
    }

    public static String verifyDay(int day) {
        switch (day) {
            case 1: return "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
            case 7: return "Sunday";
            default: return "Week contains only 7 days";

        }
    }
}