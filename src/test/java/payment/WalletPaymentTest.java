package payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WalletPaymentTest {

    @Test
    void walletAcceptsPaymentWithinBalance() {
        PaymentMethod wallet = new WalletPayment();

        assertTrue(wallet.processPayment(5000));
    }

    @Test
    void walletRejectsPaymentAboveBalance() {
        PaymentMethod wallet = new WalletPayment();

        assertFalse(wallet.processPayment(25000));
    }

    @Test
    void walletRejectsZeroPayment() {
        PaymentMethod wallet = new WalletPayment();

        assertFalse(wallet.processPayment(0));
    }

    @Test
    void walletRejectsNegativePayment() {
        PaymentMethod wallet = new WalletPayment();

        assertFalse(wallet.processPayment(-100));
    }

    @Test
    void walletDeductsBalanceAfterSuccessfulPayment() {
        WalletPayment wallet = new WalletPayment();

        assertTrue(wallet.processPayment(5000));
        assertFalse(wallet.processPayment(16000));
    }
}
