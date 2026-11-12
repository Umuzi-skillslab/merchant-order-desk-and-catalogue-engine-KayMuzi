package payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdditionalPaymentMethodsTest {

    @Test
    void payFlexPaymentIsSupported() {

        PaymentMethod paymentMethod = new PayFlexPayment();

        assertTrue(paymentMethod.processPayment(13000));
        assertEquals("PAYFLEX", paymentMethod.getPaymentType());
    }

    @Test
    void payJustNowPaymentIsSupported() {

        PaymentMethod paymentMethod = new PayJustNowPayment();

        assertTrue(paymentMethod.processPayment(13000));
        assertEquals("PAYJUSTNOW", paymentMethod.getPaymentType());
    }
}
