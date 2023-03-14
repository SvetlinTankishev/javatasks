import java.util.*;

class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private String address;
    private int age;

    public Person(String firstName, String lastName, String address, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person-[" +
                "First Name: '" + firstName + '\'' +
                ", Last Name: '" + lastName + '\'' +
                ", Address: '" + address + '\'' +
                ", Age: " + age + "]";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return this.firstName.compareTo(o.getFirstName());
    }
}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}


public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", "Doe", "Tzar Osvoboditel 121", 30));
        people.add(new Person("Jane", "Doe", "Tzar Osvoboditel 123", 30));
        people.add(new Person("Joseph", "Doe", "Tzar Osvoboditel 122", 11));

        Collections.sort(people);
        System.out.println("Sorted by first name:");
        System.out.println(people);

        Collections.sort(people, new AgeComparator());
        System.out.println("Sorted by age:");
        System.out.println(people);

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAddress().compareTo(o2.getAddress());
            }
        });
        System.out.println("Sorted by address:");
        System.out.println(people);
    }
}