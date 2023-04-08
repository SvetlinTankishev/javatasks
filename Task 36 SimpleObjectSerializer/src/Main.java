public class Main {
    public static void main(String[] args) throws Exception {
        Student student = new Student("John Doe", 123456, "123 Main St");
        SimpleObjectSerializer serializer = new SimpleObjectSerializer();
        serializer.storeToXML(student);
    }
}