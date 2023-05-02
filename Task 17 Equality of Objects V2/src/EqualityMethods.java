import java.util.ArrayList;
import java.util.HashSet;

public class EqualityMethods {
    /**
     * Tests the HashSet method which takes a list and shows non-duplicates once called.
     */
    public static void hashSetMethod() {
        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(new Person("John", "Doe", "Tzarigradsko Shose 123", 30));
        hashSet.add(new Person("Jane", "Doe", "Tzarigradsko Shose 321", 25));
        hashSet.add(new Person("John", "Doe", "Tzarigradsko Shose 123", 30));
        hashSet.add(new Person("Johnny", "B", "Kraigradska 30", 40));

        System.out.println("HashSet method test: " + hashSet);
    }

    /**
     * Tests ArrayList contains() method which implementation is based on equals() method. Tests if a name is in the array list.
     */
    public static void arrayListMethod() {
        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("John", "Doe", "Tzarigradsko Shose 123", 30));
        arrayList.add(new Person("Jane", "Doe", "Tzarigradsko Shose 321", 25));
        arrayList.add(new Person("Johnson", "Doe", "Kokiche 4", 40));

        System.out.println("ArrayList contains John Doe: " + arrayList.contains(new Person("John", "Doe", "Tzarigradsko Shose 123", 30)));
        System.out.println("ArrayList contains Alice Smith: " + arrayList.contains(new Person("Alice", "Smith", "Gorublyane 4321", 20)));
    }

    /**
     * Tests comparing methods using equals() method, == operator and compareTo() method. Creates person objects and compares them with the different methods.
     */
    public static void equalityCompareToMethod() {
        Person person1 = new Person("John", "Doe", "Tzarigradsko Shose 123", 30);
        Person person2 = new Person("Jane", "Does", "Tzarigradsko Shose 321", 30);
        Person person3 = new Person("Johnson", "Doesnt", "Kokiche 14", 25);

        System.out.println("Person1 equals Person2: " + person1.equals(person2));
        System.out.println("Person1 == Person2: " + (person1 == person2));
        System.out.println("Person1 compareTo Person2: " + person1.compareTo(person2));
        System.out.println("Person1 equals Person3: " + person1.equals(person3));
        System.out.println("Person1 == Person3: " + (person1 == person3));
        System.out.println("Person1 compareTo Person3: " + person1.compareTo(person3));
    }
}
