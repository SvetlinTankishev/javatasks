class Seller implements Runnable {
    HouseMarketplace houseMarketplace;

    public Seller(HouseMarketplace houseMarketplace) {
        this.houseMarketplace = houseMarketplace;
    }

    @Override
    public void run() {
        while (true) {
            RealEstate realEstate = new RealEstate("Address", "Type", 100);
            houseMarketplace.addRealEstateForSale(realEstate);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
