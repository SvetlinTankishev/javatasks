import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        simulateStackOverflow();
        simulateOutOfMemory();
    }

    public static void simulateStackOverflow() {
        try {
            recursiveMethod(1);
        } catch (StackOverflowError e) {
            System.out.println("Stack Overflow Error occured!");
        }
    }

    public static void recursiveMethod (int i) {
        System.out.println(i);
        recursiveMethod(i + 1);
    }

    public static void simulateOutOfMemory() {
        try {
            List<Object> list = new ArrayList<>();
            while (true) {
                list.add(new Object());
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Out of Memory Error occured!");
        }
    }
}