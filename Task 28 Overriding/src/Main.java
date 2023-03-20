public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.test();
        parent.testStatic();

        Child child = new Child();
        child.test();
        child.testStatic();

        GrandChild grandChild = new GrandChild();
        grandChild.test();
        grandChild.testStatic();


        Child child2 = new GrandChild();
        child2.test();
        child2.testStatic();


        Child child3 = new Child();
        child3.test();
        child3.testStatic();


        GrandChild grandChild2 = new GrandChild();
        grandChild2.test();
        grandChild2.testStatic();


        GrandChild grandChild3 = new GrandChild();
        grandChild3.test();
        grandChild3.testStatic();
    }
}

//When you create an object of a subclass and call an overridden method, the implementation of the method in the subclass is called instead of the implementation in the superclass
//But when you call a static method, the implementation in the class that declares the method is called, regardless of the type of object that is used to call the method