class Buyer implements Runnable {
    HouseMarketplace houseMarketplace;

    public Buyer(HouseMarketplace houseMarketplace) {
        this.houseMarketplace = houseMarketplace;
    }

    @Override
    public void run() {
        while (true) {
            houseMarketplace.buyRealEstate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
