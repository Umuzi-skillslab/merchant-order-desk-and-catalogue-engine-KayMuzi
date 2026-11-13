# Merchant Order Desk and Catalogue Engine

## Overview

The **Merchant Order Desk and Catalogue Engine** is a Java-based commerce application developed for PayNest. The system allows merchants to create and manage products, customers, and orders, calculate order totals, and generate readable order summaries.

The project was initially developed as part of **Capstone 1** and was extended in **Capstone 3: Unified Checkout Across Payment Rails**.

The Capstone 3 enhancement introduces a flexible checkout system that supports multiple payment methods through interfaces and polymorphism. This allows customers to pay using different payment methods without changing the core order or checkout logic.

---

## Features

### Capstone 1 – Merchant Order Desk

The original application supports:

- Product creation and management.
- Customer creation and management.
- Order creation.
- Adding products to orders.
- Order item management.
- Automatic order total calculation.
- Console-based order summaries.

### Capstone 3 – Unified Checkout Across Payment Rails

The application was extended to support a unified payment processing system.

The following enhancements were implemented:

- A `PaymentMethod` interface defining a common payment contract.
- Polymorphic payment processing.
- A `PaymentProcessor` class responsible for processing payments.
- Integration of payment processing into the order checkout flow.
- Support for multiple payment methods.
- Payment confirmation and order completion messages.
- Validation to reject zero or negative payment amounts across all payment methods.
- Wallet balance validation to prevent payments exceeding the available balance.

### Supported Payment Methods

The following payment methods have been implemented:

| Payment Method | Description |
|---|---|
| Card Payment | Simulates payment using a bank card. |
| EFT Payment | Simulates payment through electronic funds transfer. |
| Wallet Payment | Simulates payment using an in-app wallet. |
| PayFlex Payment | Simulates payment using PayFlex. |
| PayJustNow Payment | Simulates payment using PayJustNow. |

**Note:** Payments are simulated for demonstration purposes. No real payment gateway integrations or financial transactions are performed.

---

## Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Application development |
| Apache Maven | Project management and build automation |
| JUnit Jupiter 5.13.4 | Unit testing |
| Maven Exec Plugin 3.3.0 | Running the Java application |
| Visual Studio Code/ IntelliJ | Development environment |

---

## Requirements and Prerequisites

Before running the application, ensure that you have the following installed:

- Java Development Kit (JDK) 21 or later.
- Apache Maven.
- Visual Studio Code/IntelliJ
- Extension Pack for Java in Visual Studio Code (recommended).

You can verify your Java and Maven installations using the following commands:

Check Java:

```bash
java -version
```

Check Maven:

```bash
mvn -version
```

---

## Getting Started

### 1. Clone the Repository

Open your terminal and navigate to the directory where you want to store the project.

Clone the GitHub repository:

```bash
git clone "https://github.com/Umuzi-skillslab/merchant-order-desk-and-catalogue-engine-KayMuzi.git"
```

Navigate into the project directory:

```bash
cd merchant-order-desk-and-catalogue-engine-KayMuzi
```


### 2. Open the Project in VS Code or your chosed IDE. 

Open Visual Studio Code.

Select:

**File → Open Folder → Select the project folder.**

Ensure that you open the main project directory containing the `pom.xml` file.

Open the integrated terminal using:

**Terminal → New Terminal**

### 3. Build the Application

Run the following Maven command to compile the application:

```bash
mvn compile
```

This command compiles the Java source files and checks for compilation errors.

### 4. Run the Application

Execute the following command:

```bash
mvn exec:java
```

This starts the application using the configured main class:

```java
app.Paynest
```

The application will create sample products, register a customer, create an order, display the order summary, and process payment using the selected payment method.

### 5. Run the Unit Tests

To execute all unit tests, run:

```bash
mvn clean test
```

Maven will execute the tests using JUnit 5 and display the test results in the terminal.

---

## Unified Checkout Implementation

### PaymentMethod Interface

A common `PaymentMethod` interface was introduced to define the contract that all payment methods must follow.

```java
public interface PaymentMethod {

    boolean processPayment(double amount);

    String getPaymentType();

}
```

Every payment implementation provide these two methods.

- `processPayment(double amount)` handles payment processing and returns a success or failure result.
- `getPaymentType()` returns the payment method's identifying label.

### Payment Processing

A `PaymentProcessor` class handles payment execution and confirmation.

It accepts the `PaymentMethod` interface rather than depending on a specific payment implementation.

This allows the same checkout process to work with different payment methods.

### Checkout Demonstration

The application demonstrates polymorphism through the following implementation in `Paynest.java`:

```java
PaymentMethod paymentMethod = new EftPayment();

order.checkout(paymentMethod);
```

The selected payment method can be changed without modifying the checkout logic.

For example:

```java
PaymentMethod paymentMethod = new CardPayment();
```

Or:

```java
PaymentMethod paymentMethod = new WalletPayment();
```

The checkout call remains unchanged:

```java
order.checkout(paymentMethod);
```

This demonstrates how different payment implementations can be used through a single interface.

---

## Why Interfaces and Polymorphism Were Used

Interfaces were used to create a flexible and maintainable payment processing system.

Instead of implementing separate checkout logic for card, EFT, wallet, and other payment methods, the application uses a common `PaymentMethod` interface.

This provides several benefits:

- **Abstraction:** The checkout process depends on a common payment contract rather than individual payment classes.
- **Polymorphism:** Different payment methods can be processed using the same checkout functionality.
- **Extensibility:** New payment methods can be introduced without modifying the existing order calculation logic.
- **Maintainability:** Payment-specific behaviour is handled within individual payment classes.
- **Reduced code duplication:** The application uses one unified checkout process instead of separate payment flows.


---

## Design Decision: Monetary Values

For this project, `double` was chosen to represent monetary values and perform order total calculations, keeping the implementation simple and easy to understand. 
While this approach is suitable for the scope of the project, `BigDecimal` would be a more appropriate choice in production financial systems, where precision in monetary calculations is essential.

## Expected Application Output

When running the application with EFT selected, the expected console output is:

```text
=================================
PAYNEST ORDER SUMMARY
=================================
Order ID : 1001
Customer : Kayleigh Pepper
Email    : kayleigh@gmail.com
---------------------------------
Laptop | Qty: 1 | Subtotal: R12000.00
Wireless Keyboard | Qty: 2 | Subtotal: R1000.00
---------------------------------
GRAND TOTAL: R13000.00
=================================

Processing EFT payment for R13000
Payment successful via EFT
Amount: R13000

Order 1001 completed successfully.
```

The output demonstrates:

1. Customer and order information.
2. Products included in the order.
3. Quantity and individual line subtotals.
4. The calculated grand total.
5. The selected payment method.
6. Payment confirmation.
7. Successful order completion.

---

## Testing

The application includes unit tests written using JUnit 5.

### Domain Tests

The following tests cover the order domain:

- `OrderTest`
- `OrderItemTest`
- `OrderItemValidationTest`

These tests verify:

- Order creation and calculations.
- Order item functionality.
- Order item validation.
- Rejection of invalid payment amounts.
- Wallet balance validation and insufficient-funds handling.
- Checkout failure when a payment method is missing or payment is declined.

### Payment Tests

The following tests cover payment processing and checkout:

- `PaymentMethodTest`
- `CheckoutAmountTest`
- `OrderCheckoutTest`
- `AdditionalPaymentMethodsTest`
- `WalletPaymentTest`

These tests verify:

- Payment method functionality.
- Payment processing.
- Correct payment amounts during checkout.
- Checkout integration.
- Polymorphic payment behaviour.
- Support for additional payment methods.

### Running the Tests

Execute the following command from the project root directory:

```bash
mvn test
```

A successful test execution should display:

```text
BUILD SUCCESS
```

---

## Project Structure

The project follows a standard Maven directory structure.

```text
merchant-order-desk-and-catalogue-engine-KayMuzi
│
├── .gitignore
├── README.md
├── pom.xml
│
└── src
    │
    ├── main
    │   └── java
    │       │
    │       ├── app
    │       │   └── Paynest.java
    │       │
    │       ├── domain
    │       │   ├── Customer.java
    │       │   ├── Order.java
    │       │   ├── OrderItem.java
    │       │   └── Product.java
    │       │
    │       ├── service
    │       │   └── OrderService.java
    │       │
    │       └── payment
    │           ├── PaymentMethod.java
    │           ├── PaymentProcessor.java
    │           ├── CardPayment.java
    │           ├── EftPayment.java
    │           ├── WalletPayment.java
    │           ├── PayFlexPayment.java
    │           └── PayJustNowPayment.java
    │
    └── test
        └── java
            │
            ├── domain
            │   ├── OrderTest.java
            │   ├── OrderItemTest.java
            │   └── OrderItemValidationTest.java
            │
            └── payment
                ├── PaymentMethodTest.java
                ├── CheckoutAmountTest.java
                ├── OrderCheckoutTest.java
                └── AdditionalPaymentMethodsTest.java
                └── WalletPaymentTest.java
                
```

---

## Maven Configuration

The project uses Maven for dependency management, compilation, and test execution.

The `pom.xml` file defines:

- Project group ID: `Kayleigh`
- Artifact ID: `merchant-order-desk`
- Project version: `1.0-SNAPSHOT`
- Java compiler release: `21`
- JUnit Jupiter version: `5.13.4`
- Maven Exec Plugin version: `3.3.0`
- Main application class: `app.Paynest`

---

## Conclusion

The Merchant Order Desk and Catalogue Engine demonstrates the use of object-oriented programming principles in a practical commerce application.

Capstone 1 established the core order management functionality, while Capstone 3 extended the application with a unified checkout system.

By introducing interfaces and polymorphism, PayNest can support multiple payment methods through one consistent checkout process. This makes the application easier to maintain, extend, and adapt as additional payment methods are introduced.

The project demonstrates how abstraction, polymorphism, and separation of responsibilities can be applied to develop a flexible Java-based application.
