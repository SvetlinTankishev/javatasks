public class SubClass2 extends SubClass1 {
    static {
        System.out.println("Static block in SubClass2 executed.");
    }

    {
        System.out.println("Instance initialization block in SubClass2 executed.");
    }

    public SubClass2() {
        System.out.println("Constructor in SubClass2 executed.");
    }
}
//7. The static block in SubClass2 is executed because it is loaded when SubClass2 is loaded.
//8. Instance of SubClass2 is created which triggers initialization block and constructor in SubClass2
//9. The constructors in AbstractClass, SubClass1 and SubClass2 are all called as part of the process due to inheritance between these classes.