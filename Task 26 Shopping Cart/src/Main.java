public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Shirt", 500);
        Product product2 = new Product("Shoes", 200.0);
        Product product3 = new Product("Socks", 10);
        Product product4 = new Product("Pants", 750);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(product1);
        cart.addProduct(product2, 1);
        cart.addProduct(product3, 1);
        cart.addProduct(product4, 10);


        double totalPrice = cart.calculateTotalPrice();
        double discount = cart.getDiscount();
        double discountedPrice = totalPrice - discount;

        System.out.println("Total price: " + totalPrice);
        System.out.println("Discount: " + discount);
        System.out.println("Discounted price: " + discountedPrice);
    }
}