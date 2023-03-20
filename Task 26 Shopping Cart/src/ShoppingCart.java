import java.util.*;
public class ShoppingCart {

    private Map<Product, Integer> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void addProduct(Product p, int amount) {
        if (cart.containsKey(p)) {
            cart.put(p, cart.get(p) + amount);
        } else {
            cart.put(p, amount);
        }
    }

    public void addProduct(Product p) {
        addProduct(p, 1);
    }

    public void removeProduct(Product p, int amount) {
        if (cart.containsKey(p)) {
            int currentAmount = cart.get(p);
            if (currentAmount <= amount) {
                cart.remove(p);
            } else {
                cart.put(p, currentAmount - amount);
            }
        }
    }

    public void removeProduct(Product p) {
        removeProduct(p, 1);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;

        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product p = entry.getKey();
            int amount = entry.getValue();
            double price = p.getPrice();
            totalPrice += price * amount;
            }
        return totalPrice;
        }


    public double getDiscount() {
        double discountedPrice = 0;

        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product p = entry.getKey();
            int amount = entry.getValue();
            double price = p.getPrice();

            if (amount > 10) {
                double discount = 0.1;
                double originalProductPrice = price * amount;
                double discountedProductPrice = originalProductPrice - (originalProductPrice * discount);
                discountedPrice += originalProductPrice - discountedProductPrice;
            }
        }

        double originalPrice = calculateTotalPrice();

        if (originalPrice > 1000) {
            double discount = 0.05;
            double originalCartPrice = originalPrice;
            originalPrice = originalCartPrice - (originalCartPrice * discount);
            discountedPrice += originalCartPrice - originalPrice;
        }

        return discountedPrice;
    }
}
