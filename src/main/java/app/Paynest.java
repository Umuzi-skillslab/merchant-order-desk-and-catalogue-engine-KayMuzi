package app;

import domain.Customer;
import domain.Order;
import domain.Product;
import service.OrderService;

import payment.CardPayment;
import payment.PayFlexPayment;
import payment.PayJustNowPayment;
import payment.EftPayment;
import payment.WalletPayment;
import payment.PaymentMethod;

public class Paynest {

    public static void main(String[] args) {

        Product laptop = new Product(1, "Laptop", 12000);
        Product keyboard = new Product(2, "Wireless Keyboard", 500);

        Customer customer = new Customer(
                1,
                "Kayleigh Pepper",
                "kayleigh@gmail.com"
        );

        OrderService orderService = new OrderService();

        Order order = orderService.createOrder(1001, customer);

        orderService.addItem(order, laptop, 1);
        orderService.addItem(order, keyboard, 2);

        order.printSummary();

        PaymentMethod paymentMethod = new EftPayment();


        order.checkout(paymentMethod);
    }
}
