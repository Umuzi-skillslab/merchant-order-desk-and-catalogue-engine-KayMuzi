package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderItemValidationTest {

    @Test
    void quantityMustBeGreaterThanZero() {

        Product product =
                new Product(1, "Laptop", 12000);

        assertThrows(
                IllegalArgumentException.class,
                () -> new OrderItem(product, 0)
        );
    }
}