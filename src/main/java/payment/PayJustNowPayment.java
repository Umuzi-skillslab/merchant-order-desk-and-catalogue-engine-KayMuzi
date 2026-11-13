
package payment;

public class PayJustNowPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {

        if (amount <= 0) {
            System.out.println("PayJustNow payment failed: Invalid payment amount.");
            return false;
        }

        System.out.println(
                "Processing PayJustNow payment for R"
                        + String.format("%.0f", amount)
        );

        return true;
    }

    @Override
    public String getPaymentType() {
        return "PAYJUSTNOW";
    }
}
