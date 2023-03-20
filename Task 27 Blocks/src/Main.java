public class Main {
    public static void main(String[] args) {
        SubClass1 obj1 = new SubClass1();
        System.out.println();
        SubClass2 obj2 = new SubClass2();
        System.out.println();
    }
}

//1. Static block in the Abstract Class is executed first because it is loaded when the program starts.
//2. The static block in SubClass1 is executed because it is loaded when the SubClass1 is loaded.
//3. An instance of the AbstractClass is executed since it runs every time an object of the class is created,
//   in this case, it's extended in SubClass1.
//4. The Constructor of the abstract class is executed, since it is responsible for initializing the instance variables, which in this case is being created.
//5. An instance of SubClass1 is created in the main method, which triggers the instance initialization block and constructor in SubClass1 to be executed.
//6. Constructor in SubClass1 is executed due to the inheritance.
//7. The static block in SubClass2 is executed because it is loaded when SubClass2 is loaded.
//8. Instance of SubClass2 is created which triggers initialization block and constructor in SubClass2.
//9. The constructors in AbstractClass, SubClass1 and SubClass2 are all called as part of the process due to inheritance between these classes.