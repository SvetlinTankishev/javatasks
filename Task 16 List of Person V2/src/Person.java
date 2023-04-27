public record Person(String firstName, String lastName, String address, int age) implements Comparable<Person> {

    @Override
    public String toString() {
        return "Person - [" +
                "First Name: '" + firstName + '\'' +
                ", Last Name: '" + lastName + '\'' +
                ", Address: '" + address + '\'' +
                ", Age: " + age + "]";
    }

    @Override
    public int compareTo(Person o) {
        return this.firstName.compareTo(o.firstName());
    }
}
