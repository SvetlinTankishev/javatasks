import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HouseMarketplace {

    private List<RealEstate> realEstateList;
    private double currentPricePerSquareMeter;

    public HouseMarketplace(double currentPricePerSquareMeter) {
        this.currentPricePerSquareMeter = currentPricePerSquareMeter;
        realEstateList = new ArrayList<>();
    }

    public synchronized void addRealEstateForSale(RealEstate realEstate) {
        realEstateList.add(realEstate);
        adjustMarketPrice();
    }

    public synchronized RealEstate buyRealEstate() {
        if (realEstateList.isEmpty()) {
            return null;
        }
        RealEstate realEstate = realEstateList.remove(new Random().nextInt(realEstateList.size()));
        adjustMarketPrice();
        return realEstate;
    }

    void adjustMarketPrice() {
        int numRealEstate = realEstateList.size();
        if (numRealEstate > 300) {
            currentPricePerSquareMeter *= 0.88; // reduce by 12%
        } else {
            currentPricePerSquareMeter *= 1.15; // increase by 15%
        }
    }

    public List<RealEstate> getRealEstateList() {
        return realEstateList;
    }

    public double getCurrentPricePerSquareMeter() {
        return currentPricePerSquareMeter;
    }
}