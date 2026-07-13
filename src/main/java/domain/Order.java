package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private final int id;
    private final Customer customer;
    private final List<OrderItem> items;

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(Product product, int quantity) {
        items.add(new OrderItem(product, quantity));
    }

    public double calculateTotal() {

        double total = 0;

        for (OrderItem item : items) {
            total += item.calculateTotal();
        }

        return total;
    }

    public void printSummary() {

        System.out.println("=================================");
        System.out.println("PAYNEST ORDER SUMMARY");
        System.out.println("=================================");
        System.out.println("Order ID : " + id);
        System.out.println("Customer : " + customer.getName());
        System.out.println("Email    : " + customer.getEmail());
        System.out.println("---------------------------------");

        for (OrderItem item : items) {

            String productName = item.getProduct().getName();
            int quantity = item.getQuantity();
            double subtotal = item.calculateTotal();

            System.out.printf(
                    "%s | Qty: %d | Subtotal: R%.2f%n",
                    productName,
                    quantity,
                    subtotal
            );
        }

        System.out.println("---------------------------------");
        System.out.printf(
                "GRAND TOTAL: R%.2f%n",
                calculateTotal()
        );

        System.out.println("=================================");
    }
}