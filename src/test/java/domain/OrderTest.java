package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Test
    void calculateTotalReturnsGrandTotal() {

        Customer customer =
                new Customer(1, "Kayleigh", "kayleigh@gmail.com");

        Order order = new Order(1001, customer);

        Product laptop =
                new Product(1, "Laptop", 12000);

        Product keyboard =
                new Product(2, "Keyboard", 500);

        order.addItem(laptop, 1);
        order.addItem(keyboard, 2);

        assertEquals(13000.0, order.calculateTotal(), 0.001);
    }


    @Test
    void emptyOrderReturnsZeroTotal() {

        Customer customer =
                new Customer(1, "Kayleigh", "kayleigh@gmail.com");

        Order order = new Order(1001, customer);

        assertEquals(0.0, order.calculateTotal(), 0.001);
    }
}