public class Main {
    public static void main(String[] args) {
        Bag bag = new Bag();

        bag.add("apple");
        bag.add("banana");
        bag.add("cherry");
        bag.add("banana");

        System.out.println("Bag contents: " + bag.toString());

        bag.remove("cherry");

        System.out.println("Bag contents after removing cherry: " + bag.toString());

        System.out.println("Random element: " + bag.grab());

        System.out.println("Element at index 1: " + bag.grab(1));

        System.out.println("Bag contains 'banana': " + bag.contains("banana"));

        bag.clear();

        System.out.println("Bag contents after clearing: " + bag.toString());
    }
}