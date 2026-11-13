package payment;

public class EftPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {

        if (amount <= 0) {
            System.out.println("EFT payment failed: Invalid payment amount.");
            return false;
        }

        System.out.println(
                "Processing EFT payment for R"
                        + String.format("%.0f", amount)
        );

        return true;
    }

    @Override
    public String getPaymentType() {
        return "EFT";
    }
}
