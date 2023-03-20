abstract class AbstractClass {
    static {
        System.out.println("Static block in AbstractClass executed.");
    }

    {
        System.out.println("Instance initialization block in AbstractClass executed.");
    }

    public AbstractClass() {
        System.out.println("Constructor in AbstractClass executed.");
    }
}
//1. Static block in the Abstract Class is executed first because it is loaded when the program starts.
//3. An instance of the AbstractClass is executed since it runs every time an object of the class is created,
//   in this case, it's extended in SubClass1
//4. The Constructor of the abstract class is executed, since it is responsible for initializing the instance variables, which in this case is being created.