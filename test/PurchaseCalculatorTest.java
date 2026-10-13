import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PurchaseCalculatorTest {

    PurchaseCalculator purchaseCalculator = new PurchaseCalculator();

    @Test
    @DisplayName("Prueba cálculo Subtotal")
    public void pruebaSubtotal() {
        assertEquals(300.00, purchaseCalculator.calculateSubtotal(100.00, 3), 0.001);
        assertEquals(100.00, purchaseCalculator.calculateSubtotal(100.00, 1), 0.001);
        assertEquals(0.00, purchaseCalculator.calculateSubtotal(0.00, 1), 0.001);
    }

    @Test
    @DisplayName("Validación de la compra")
    public void pruebaValidacionCompra() {
        assertTrue(purchaseCalculator.isValidPurchase(100.00, 3));
        assertFalse(purchaseCalculator.isValidPurchase(0.00, 1));
        assertFalse(purchaseCalculator.isValidPurchase(200.00, 0));
        assertFalse(purchaseCalculator.isValidPurchase(-200.00, 2));
    }

    @Test
    @DisplayName("Prueba cálculo del descuento")
    public void pruebaDescuento() {
        assertEquals(0.00, purchaseCalculator.calculateDiscount(999.99), 0.001);
        assertEquals(100.00, purchaseCalculator.calculateDiscount(1000.00), 0.001);
        assertEquals(150.00, purchaseCalculator.calculateDiscount(1500.00), 0.001);
    }

    @Test
    @DisplayName("Prueba cálculo del precio final")
    public void pruebaPrecioFinal() {
        assertEquals(500.00, purchaseCalculator.calculateFinalPrice(500.00), 0.001);   // sin descuento
        assertEquals(900.00, purchaseCalculator.calculateFinalPrice(1000.00), 0.001); // justo en el límite
        assertEquals(1350.00, purchaseCalculator.calculateFinalPrice(1500.00), 0.001); // con descuento
    }
}
