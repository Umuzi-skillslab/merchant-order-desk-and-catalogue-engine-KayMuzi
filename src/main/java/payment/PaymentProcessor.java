package payment;

public class PaymentProcessor {

    public boolean processPayment(
            PaymentMethod method,
            double amount
    ) {

        boolean success = method.processPayment(amount);

        if (success) {
            System.out.println(
                    "Payment successful via "
                            + method.getPaymentType()
            );

            System.out.println(
                    "Amount: R"
                            + String.format("%.0f", amount)
            );

        } else {
            System.out.println(
                    "Payment failed via "
                            + method.getPaymentType()
            );
        }

        return success;
    }
}
