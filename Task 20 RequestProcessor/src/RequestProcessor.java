import java.util.LinkedList;
import java.util.Queue;

class RequestProcessor {
    private Queue<String> requestQueue = new LinkedList<>();

    public void addRequest(String request) {
        requestQueue.add(request);
    }

    public void processAllRequests() {
        while (!requestQueue.isEmpty()) {
            String request = requestQueue.remove();
            process(request);
        }
    }

    private void process(String request) {
        System.out.println("Processing \"" + request + "\"");
    }
}
