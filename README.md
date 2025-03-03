# Delivery Management System

## Project Overview

This project is a simple delivery management system for a restaurant that allows a customer to place an order, and based on availability, assigns a driver to deliver the order. The system uses several classes like `Customer`, `Restaurant`, `Driver`, and `DriverManager` to manage the customer order and delivery assignment.

## Features

- Customer details input and order management.
- Restaurant details and meal price calculations.
- Driver selection based on the smallest load available within a specific location.
- Invoice generation and file output.

## Requirements

To run this project, make sure you have the following:

- Java 8+ installed on your machine.
- A text file named `drivers.txt` in the project directory with driver information (name, location, and load).
- The project uses the `java.io` package for file operations, so ensure file access is allowed.

## Detailed Class Descriptions

### `Customer.java`
- Stores customer-related information (order number, name, contact details).
- Includes a `toString` method to display customer details.

### `Driver.java`
- Stores driver-related information (name, location, and load).
- Includes a `toString` method for displaying driver details.

### `DriverManager.java`
- Manages the list of drivers, reads data from `drivers.txt`, and finds the driver with the smallest load that is available to make the delivery.

### `Restaurant.java`
- Stores restaurant-related information (name, location, contact details, meals, and special instructions).
- Calculates the total amount for the order based on the list of meals and their prices.

### `Main.java`
- The main entry point of the program where customer and restaurant details are entered.
- Displays the order details and generates an invoice.
- Handles file I/O for saving the invoice to `invoice.txt`.

## How to Run

1. Clone or download the repository.
2. Open a terminal and navigate to the project directory.

### Compile the Java files:

```bash
javac src/*.java
Run the program:
java src.Main
Follow the prompts in the terminal to enter customer, restaurant, and order details.
The program will generate an invoice and save it to invoice.txt.
