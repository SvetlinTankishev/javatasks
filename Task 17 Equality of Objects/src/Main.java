import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

class Person implements Comparable<Person> {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final int age;

    public Person(String firstName, String lastName, String address, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person o) {
            return Objects.equals(firstName, o.firstName) &&
                   Objects.equals(lastName, o.lastName) &&
                   Objects.equals(address, o.address) &&
                   age == o.age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, age);
    }

    @Override
    public String toString() {
        return String.format("Person-[First Name: '%s', Last Name: '%s', Address: '%s', Age: %d]",
                firstName, lastName, address, age);
    }
    @Override
    public int compareTo(Person o) {
        int result = this.lastName.compareTo(o.lastName);
        if (result != 0) {
            return result;
        }
        result = this.firstName.compareTo(o.firstName);
        if (result != 0) {
            return result;
        }
        return Integer.compare(this.age, o.age);
    }
}

public class Main {

    public static void main(String[] args) {
        hashSet();
        arrayList();
        equalityCompareTo();
    }

    public static void hashSet() {
        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(new Person("John", "Doe", "Tzarigradsko Shose 123", 30));
        hashSet.add(new Person("Jane", "Doe", "Tzarigradsko Shose 321", 25));
        hashSet.add(new Person("John", "Doe", "Mostova 23", 30));
        hashSet.add(new Person("Johnny", "B", "Kraigradska 30", 40));

        System.out.println("HashSet: " + hashSet);
    }

    public static void arrayList() {
        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("John", "Doe", "Tzarigradsko Shose 123", 30));
        arrayList.add(new Person("Jane", "Doe", "Tzarigradsko Shose 321", 25));
        arrayList.add(new Person("Johnson", "Doe", "Kokiche 4", 40));

        System.out.println("ArrayList contains John Doe: " + arrayList.contains(new Person("John", "Doe", "Tzarigradsko Shose 123", 30)));
        System.out.println("ArrayList contains Alice Smith: " + arrayList.contains(new Person("Alice", "Smith", "Gorublyane 4321", 20)));
    }

    public static void equalityCompareTo() {
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
