package payment;

import domain.Customer;
import domain.Order;
import domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckoutAmountTest {

    @Test
    void checkoutPassesOrderTotalToPaymentMethod() {

        Customer customer =
                new Customer(1, "Kayleigh", "kayleigh@gmail.com");

        Order order = new Order(1001, customer);

        Product laptop =
                new Product(1, "Laptop", 12000);

        Product keyboard =
                new Product(2, "Keyboard", 500);

        order.addItem(laptop, 1);
        order.addItem(keyboard, 2);

        TestPaymentMethod paymentMethod =
                new TestPaymentMethod();

        assertTrue(order.checkout(paymentMethod));

        assertEquals(
                order.calculateTotal(),
                paymentMethod.getReceivedAmount(),
                0.001
        );
    }

    private static class TestPaymentMethod
            implements PaymentMethod {

        private double receivedAmount;

        @Override
        public boolean processPayment(double amount) {
            receivedAmount = amount;
            return true;
        }

        @Override
        public String getPaymentType() {
            return "TEST";
        }

        public double getReceivedAmount() {
            return receivedAmount;
        }
    }
}
