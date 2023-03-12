public class Main {
    public static void main(String[] args) {
        int[] numbers = {-2, 30, -10, 12, 80, 8, 64, 44, 64, 18};
        int biggestOdd = findBiggestOdd(numbers);
        if (biggestOdd == Integer.MIN_VALUE) {
            System.out.println("There are no odd numbers in the array.");
        } else {
            System.out.println("The biggest odd number is: " + biggestOdd);
        }
    }

    public static int findBiggestOdd(int[] numbers) {
        int biggestOdd = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number % 2 != 0 && number > biggestOdd) {
                biggestOdd = number;
            }
        }
        return biggestOdd;
    }
}