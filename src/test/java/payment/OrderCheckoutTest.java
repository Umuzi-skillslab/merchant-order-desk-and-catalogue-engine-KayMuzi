package payment;

import domain.Customer;
import domain.Order;
import domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderCheckoutTest {

    @Test
    void checkoutSucceedsWithCardPayment() {

        Customer customer =
                new Customer(1, "Kayleigh", "kayleigh@gmail.com");

        Order order = new Order(1001, customer);

        Product laptop =
                new Product(1, "Laptop", 12000);

        Product keyboard =
                new Product(2, "Keyboard", 500);

        order.addItem(laptop, 1);
        order.addItem(keyboard, 2);

        PaymentMethod paymentMethod = new CardPayment();

        assertTrue(order.checkout(paymentMethod));
    }

    @Test
    void checkoutSucceedsWithWalletPayment() {

        Customer customer =
                new Customer(1, "Kayleigh", "kayleigh@gmail.com");

        Order order = new Order(1001, customer);

        Product laptop =
                new Product(1, "Laptop", 12000);

        order.addItem(laptop, 1);

        PaymentMethod paymentMethod = new WalletPayment();

        assertTrue(order.checkout(paymentMethod));
    }
}
