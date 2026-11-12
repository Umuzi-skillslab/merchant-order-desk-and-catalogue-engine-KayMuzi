package payment;

public class PayFlexPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
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
