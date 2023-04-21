import java.util.*;

public class Person {
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        return firstName.equals(other.firstName)
                && lastName.equals(other.lastName)
                && address.equals(other.address)
                && age == other.age;
    }
    // generate a hash code from the fields, which is a convenience method that combines the hash codes of multiple fields into a single hash code
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", Address='" + address + '\'' +
                ", Age=" + age +
                '}';
    }
    // compareTo method compares strings based on their ASCII values
    // used by certain collection classes in java, such as TreeSet and TreeMap to sort and organize elements in the collection
    // it defines the natural ordering of the elements ion the collection, and if it is not implemented correctly it can lead to unexpected behavior.
    public int compareTo(Person other) {
        int result = lastName.compareTo(other.lastName);
        if (result == 0) {
            result = firstName.compareTo(other.firstName);
        }
        if (result == 0) {
            result = Integer.compare(age, other.age);
        }
        return result;
    }
}
