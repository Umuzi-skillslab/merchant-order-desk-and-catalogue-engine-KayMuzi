package payment;

public class WalletPayment implements PaymentMethod {

    private double balance = 20000;

    @Override
    public boolean processPayment(double amount) {

        if (amount <= 0 || amount > balance) {
            System.out.println("Wallet payment failed: Invalid amount or insufficient funds.");
            return false;
        }

        System.out.println(
                "Processing wallet payment for R"
                        + String.format("%.0f", amount)
        );

        balance -= amount;

        System.out.println(
                "Remaining wallet balance: R"
                        + String.format("%.0f", balance)
        );

        return true;
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
}
