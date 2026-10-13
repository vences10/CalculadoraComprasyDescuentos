public class PurchaseCalculator {

    // Devuelve el precio * cantidad
    public double calculateSubtotal(double price, int quantity) {
        return price * quantity;
    }

    // Devuelve true si precio > 0 y cantidad > 0
    public boolean isValidPurchase(double price, int quantity) {
        return price > 0 && quantity > 0;
    }

    // Devuelve el descuento (10% si subtotal >= 1000, si no 0)
    public double calculateDiscount(double subtotal) {
        if (subtotal >= 1000) {
            return subtotal * 0.10;
        }
        return 0.0;
    }

    // Devuelve subtotal - descuento
    public double calculateFinalPrice(double subtotal) {
        double discount = calculateDiscount(subtotal);
        return subtotal - discount;
    }
}
