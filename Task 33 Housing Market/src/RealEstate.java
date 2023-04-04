public class RealEstate {
    private String address;
    private String type;
    private double squareMeters;

    public RealEstate(String address, String type, double squareMeters) {
        this.address = address;
        this.type = type;
        this.squareMeters = squareMeters;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public double getSquareMeters() {
        return squareMeters;
    }
}