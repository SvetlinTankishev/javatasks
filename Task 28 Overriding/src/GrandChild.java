class GrandChild extends Child {
    @Override
    public void test() {
        System.out.println("test method from GrandChild class");
    }

    public static void testStatic() {
        System.out.println("testStatic method from GrandChild class");
    }
}