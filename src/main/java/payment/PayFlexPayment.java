package payment;

public class PayFlexPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {

        if (amount <= 0) {
            System.out.println("PayFlex payment failed: Invalid payment amount.");
            return false;
        }

        System.out.println(
                "Processing PayFlex payment for R"
                        + String.format("%.0f", amount)
        );

        return true;
    }

    @Override
    public String getPaymentType() {
        return "PAYFLEX";
    }
}
