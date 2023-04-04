import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class HouseMarketplace {
    List<RealEstate> realEstates = new ArrayList<>();
    double currentPricePerSquareMeter = 1000;

    public synchronized void addRealEstateForSale(RealEstate realEstate) {
        realEstates.add(realEstate);
        adjustCurrentPrice();
    }

    public synchronized RealEstate buyRealEstate() {
        if (realEstates.size() > 0) {
            int index = new Random().nextInt(realEstates.size());
            RealEstate realEstate = realEstates.remove(index);
            double price = realEstate.squareMeters * currentPricePerSquareMeter;
            adjustCurrentPrice();
            return realEstate;
        } else {
            return null;
        }
    }

    private void adjustCurrentPrice() {
        if (realEstates.size() > 300) {
            currentPricePerSquareMeter *= 0.88;
        } else if (realEstates.size() < 300) {
            currentPricePerSquareMeter *= 1.15;
        }
    }
}
