import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Create a new HouseMarketplace object
        HouseMarketplace marketplace = new HouseMarketplace(300);

        // Create multiple Seller and Buyer threads
        for (int i = 0; i < 10; i++) {
            Thread sellerThread = new Thread(new Seller(marketplace));
            sellerThread.start();

            Thread buyerThread = new Thread(new Buyer(marketplace));
            buyerThread.start();
        }

        // Simulate the marketplace for a period of time
        int simulationTime = 30000; // in milliseconds
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        while ((System.currentTimeMillis() - startTime) < simulationTime) {
            try {
                // Adjust the market price
                marketplace.adjustMarketPrice();

                // Control the number of added and bought RealEstate objects
                int numRealEstate = marketplace.getRealEstateList().size();
                if (numRealEstate < 50) {
                    // Add more RealEstate objects
                    marketplace.addRealEstateForSale(new RealEstate("Address " + (numRealEstate+1), "House", random.nextInt(200)+50));
                } else if (numRealEstate > 200) {
                    // Reduce the number of Seller threads to prevent oversupply
                    Thread.sleep(500);
                } else {
                    // Keep the number of RealEstate objects and threads constant
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}