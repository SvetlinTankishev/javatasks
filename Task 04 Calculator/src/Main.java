import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter two numbers:");
            double num1 = input.nextDouble();
            double num2 = input.nextDouble();

            System.out.println("Enter the operation number (1-add, 2-subtract, 3-multiply, 4-exit):");
            int operation = input.nextInt();

            double result = 0;
            switch (operation) {
                case 1:
                    result = add(num1, num2);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid operation number. Try again.");
                    continue;
            }
            System.out.println("The result is: " + result);
        }
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }
}