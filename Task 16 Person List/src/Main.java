import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("John", "Doe", "123 Blah blah Str", 30);
        Person person2 = new Person("Jane", "Ode", "123 Bmah blah Str", 23);
        Person person3 = new Person("John", "Doe", "123 Blah blah Str", 30);
        Person person4 = new Person("Jannet", "Edo", "123 Bwah Str", 38);
        Person person5 = new Person("Jack", "Do", "123 Blah blah Str", 23);
        //test HashSet
        Set<Person> personSet = new HashSet<>();
        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);
        personSet.add(person4);
        personSet.add(person5);

        System.out.println("Person set size: " + personSet.size());
        System.out.println("Person set contents: " + personSet);

        //test ArrayList
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person1);

        System.out.println("Person list contains person1: " + personList.contains(person1));
        System.out.println("Person list conation person3: " + personList.contains(person3));

        //test equality
        System.out.println("Is person 1 equal to person 2?: " + person1.equals(person2));
        System.out.println("Is person 1 equal to person 3?: " + person1.equals(person3));
        System.out.println("Is person 1 == person 3?: " + (person1 == person3));
        System.out.println("Does person 1 compare to person 2?: " + person1.compareTo(person2));
        System.out.println("Does person 1 compare to person 3?: " + person1.compareTo(person3));


    }
}


