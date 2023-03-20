class SubClass1 extends AbstractClass {
    static {
        System.out.println("Static block in SubClass1 executed.");
    }

    {
        System.out.println("Instance initialization block in SubClass1 executed.");
    }

    public SubClass1() {
        System.out.println("Constructor in SubClass1 executed.");
    }
}
//2. The static block in SubClass1 is executed because it is loaded when the SubClass1 is loaded.
//5. An instance of SubClass1 is created in the main method, which triggers the instance initialization block in SubClass1 to be executed.
//6. Constructor in SubClass1 is executed due to the inheritance.