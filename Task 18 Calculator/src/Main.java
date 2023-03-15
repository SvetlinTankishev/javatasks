import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the operation you want to perform ( +, - or * ):");
        String operator = input.nextLine();

        System.out.println("Enter first number: ");
        String a = input.nextLine();

        System.out.println("Enter second number: ");
        String b = input.nextLine();

        String result;

        switch (operator) {
            case "+" -> result = add(a, b);
            case "-" -> result = subtract(a, b);
            case "*" -> result = multiply(a, b);
            default -> {
                System.out.println("Invalid operator!");
                return;
            }
        }
        System.out.println("Result: " + result);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static String add(String a, String b) {
        double num1 = Double.parseDouble(a);
        double num2 = Double.parseDouble(b);
        double sum = num1 + num2;
        return String.valueOf(sum);
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static double subtract (double a, double b) {
        return a - b;
    }

    public static String subtract (String a, String b) {
        double num1 = Double.parseDouble(a);
        double num2 = Double.parseDouble(b);
        double diff = num1 - num2;
        return String.valueOf(diff);
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static String multiply(String a, String b) {
        double num1 = Double.parseDouble(a);
        double num2 = Double.parseDouble(b);
        double product = num1 * num2;
        return String.valueOf(product);
    }

}