package payment;

import domain.Customer;
import domain.Order;
import domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaymentMethodTest {

    @Test
    void checkoutCanUseDifferentPaymentMethods() {

        Customer customer =
                new Customer(1, "Kayleigh", "kayleigh@gmail.com");

        Order order = new Order(1001, customer);

        Product laptop =
                new Product(1, "Laptop", 12000);

        Product keyboard =
                new Product(2, "Keyboard", 500);

        order.addItem(laptop, 1);
        order.addItem(keyboard, 2);

        PaymentMethod card = new CardPayment();
        PaymentMethod wallet = new WalletPayment();

        assertTrue(card.processPayment(order.calculateTotal()));
        assertTrue(wallet.processPayment(order.calculateTotal()));

        assertEquals("CARD", card.getPaymentType());
        assertEquals("WALLET", wallet.getPaymentType());
    }
}
