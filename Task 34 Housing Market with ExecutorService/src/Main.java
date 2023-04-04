import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        HouseMarketplace houseMarketplace = new HouseMarketplace();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Seller(houseMarketplace));
            executorService.execute(new Buyer(houseMarketplace));
        }
    }
}