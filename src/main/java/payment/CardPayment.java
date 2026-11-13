package payment;

public class CardPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {

        if (amount <= 0) {
            System.out.println("Card payment failed: Invalid payment amount.");
            return false;
        }

        System.out.println(
                "Processing card payment for R"
                        + String.format("%.0f", amount)
        );

        return true;
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }
}
