import java.util.Random;

public class Buyer implements Runnable {
    private HouseMarketplace marketplace;
    private int numHousesToBuy;
    private int minSleepTime;
    private int maxSleepTime;

    public Buyer(HouseMarketplace marketplace) {
        this.marketplace = marketplace;
        this.numHousesToBuy = numHousesToBuy;
        this.minSleepTime = minSleepTime;
        this.maxSleepTime = maxSleepTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < numHousesToBuy; i++) {
            RealEstate house = marketplace.buyRealEstate();
            if (house != null) {
                System.out.println(Thread.currentThread().getName() + " bought a " + house.getSquareMeters() + " square meter " + house.getType() + " at " + house.getAddress() + " for " + house.getSquareMeters() * marketplace.getCurrentPricePerSquareMeter() + " euros.");
            }
            try {
                Thread.sleep(new Random().nextInt(maxSleepTime - minSleepTime + 1) + minSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}