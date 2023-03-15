
public class Main {
    public static void main(String[] args) {
        RequestProcessor processor = new RequestProcessor();
        processor.addRequest("request1");
        processor.addRequest("request2");
        processor.addRequest("request3");
        processor.processAllRequests();
    }
}