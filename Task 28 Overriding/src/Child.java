class Child extends Parent {
    @Override
    public void test() {
        System.out.println("test method from Child class");
    }

    public static void testStatic() {
        System.out.println("testStatic method from Child class");
    }
}