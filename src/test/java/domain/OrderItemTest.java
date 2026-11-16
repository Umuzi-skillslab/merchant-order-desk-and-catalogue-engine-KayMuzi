package domain;
 
import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
 
class OrderItemTest {
 
    @Test
    void calculateTotalReturnsCorrectSubtotal() {
 
        Product product = new Product(1, "Laptop", 12000);
 
        OrderItem item = new OrderItem(product, 2);
 
        assertEquals(24000, item.calculateTotal());
    }
}