import java.util.Objects;

public class Person implements Comparable<Person> {
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
    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person o) {
            return Objects.equals(firstName, o.firstName) &&
                    Objects.equals(lastName, o.lastName) &&
                    Objects.equals(address, o.address) &&
                    age ==  o.age;
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
