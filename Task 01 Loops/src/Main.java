public class Main {
    public static void main(String[] args) {
        printForLoop();
        printWhileLoop();
        printDoWhileLoop();
    }

    public static void printForLoop() {
        System.out.print("Using for loop: ");
        for (int i = 0; i < 100; i++) {
            System.out.print(i);
            if (i != 99) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void printWhileLoop() {
        System.out.print("Using while loop: ");
        int i = 0;
        while (i < 100) {
            System.out.print(i);
            if (i != 99) {
                System.out.print(", ");
            }
            i++;
        }
        System.out.println();
    }

    public static void printDoWhileLoop() {
        System.out.print("Using do-while loop: ");
        int i = 0;
        do {
            System.out.print(i);
            if (i !=99) {
                System.out.print(", ");
            }
            i++;
        } while (i < 100);
        System.out.println();
    }
}