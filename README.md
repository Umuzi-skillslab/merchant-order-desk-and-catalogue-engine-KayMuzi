[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=24000846&assignment_repo_type=AssignmentRepo)
# Merchant-order-desk-and-catalogue-engine

## Overview

This project is a simple Java-based commerce system for PayNest. It allows merchants to create products, customers, and orders, calculate order totals, and print a readable order summary to the console.

## Requirements

- Java 21 or later
- Apache Maven

## Build

```bash
mvn compile
```

## Run the application

```bash
mvn exec:java
```

## Run the tests

```bash
mvn test
```

## Expected Output

Running the application prints an order summary containing:

- Customer information
- Ordered products
- Quantities
- Line subtotals
- Grand total

Example:

```
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
```

## Project structure

merchant-order-desk-and-catalogue-engine-KayMuzi
│
├── .gitignore
├── README.md
├── pom.xml
│
└── src
    ├── main
    │   └── java
    │       ├── app
    │       │   └── Paynest.java
    │       │
    │       ├── domain
    │       │   ├── Product.java
    │       │   ├── Customer.java
    │       │   ├── Order.java
    │       │   └── OrderItem.java
    │       │
    │       └── service
                 |── OrderService.java
    │
    └── test
        └── java
            └── domain
                ├── OrderTest.java
                ├── OrderItemTest.java
                └── OrderItemValidationTest.java