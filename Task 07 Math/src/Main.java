import java.util.Random;

public class Main {

    public static double absoluteValue(double number) {
        return Math.abs(number);
    }

    public static double roundOff(double number) {
        return  Math.round(number);
    }

    public static double ceilValue (double number) {
        return Math.ceil(number);
    }

    public static double min (double number1, double number2) {
        return Math.min(number1, number2);
    }

    public static double max (double number1, double number2) {
        return Math.max(number1, number2);
    }

    public static double calculateAreaOfCircle(double radius) {
        return Math.PI * radius * radius;
    }

    public static double squareRoot(double x) {
        return Math.sqrt(x);
    }

    public static int randomInt() {
        Random random = new Random();
        return random.nextInt(101);
    }

    public static void main(String[] args) {

        double number = -34.56;
        double number1 = -2.14;
        double number2 = 6.78;
        double x = 51.7;
        double radius = 7.7;

        System.out.println("Absolute value of " + number + " is " + absoluteValue(number));

        System.out.println(number + " rounds off to " + roundOff(number));

        System.out.println("Smallest integer greater than or equal to " + number + " is " + ceilValue(number));

        System.out.println("The smaller of the two arguments " + number1 + " and " + number2 + " is " + min(number1, number2));

        System.out.println("The bigger of the two arguments " + number1 + " and " + number2 + " is " + max(number1, number2));

        System.out.println("Knowing the radius is " + radius + ", we can find out the area of the circle is " + calculateAreaOfCircle(radius));

        System.out.println("The square root of " + x + " is " + squareRoot(x));

        System.out.println("A random integer value between 0 and 100 is " +randomInt());
    }
}