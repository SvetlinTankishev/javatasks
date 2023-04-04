import java.util.Random;

public class Seller implements Runnable {
    private HouseMarketplace marketplace;
    private int numHousesToAdd;
    private int minSleepTime;
    private int maxSleepTime;

    public Seller(HouseMarketplace marketplace) {
        this.marketplace = marketplace;
        this.numHousesToAdd = numHousesToAdd;
        this.minSleepTime = minSleepTime;
        this.maxSleepTime = maxSleepTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < numHousesToAdd; i++) {
            Random rand = new Random();
            double squareMeters = rand.nextDouble() * 100 + 50; // Random value between 50 and 150
            RealEstate house = new RealEstate("Address " + i, "House", squareMeters);
            marketplace.addRealEstateForSale(house);
            try {
                Thread.sleep(rand.nextInt(maxSleepTime - minSleepTime + 1) + minSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}