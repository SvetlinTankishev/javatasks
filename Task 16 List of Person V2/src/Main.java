import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jane", "Does", "Tiananmen Square 16", 21));
        people.add(new Person("John", "Doesnt", "Wallstreet 1", 31));
        people.add(new Person( "Josep", "Didnt", "Neverland Street 17", 54));

        Collections.sort(people);
        System.out.println("Sorted by first name:");
        System.out.println(people);

        people.sort(new AgeComparator());
        System.out.println("Sorted by age:");
        System.out.println(people);

        people.sort(Comparator.comparing(Person::getAddress));
        System.out.println("Sorted by address:");
        System.out.println(people);
    }
}