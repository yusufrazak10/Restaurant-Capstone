package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

  public static void main(String[] args) {

    // Initialize Scanner object for user input
    Scanner scanner = new Scanner(System.in);

    // Prompt user to enter customer details
    System.out.print("Please enter customers details: \n\n");

    // Initialize variable.
    int customerOrderNumber;

    while (true) {
      try {
        // Prompt user to enter order number.
        System.out.print("Order Number: ");
        // Read the next integer.
        customerOrderNumber = scanner.nextInt();
        scanner.nextLine();
        // Exit the loop.
        break;
      } catch (InputMismatchException e) {
        // Handle the case where the input is not a valid integer.
        System.err.println("Please enter a valid number");
        scanner.nextLine();
      }
    }

    // Prompt the user for other details and read the next line.
    System.out.print("Customer Name: ");
    String customerName = scanner.nextLine();
    System.out.print("Contact Number: ");
    String customerContactNumber = scanner.nextLine();
    System.out.print("Address: ");
    String customerAddress = scanner.nextLine();
    System.out.print("Location: ");
    String customerLocation = scanner.nextLine();
    System.out.print("Email: ");
    String customerEmail = scanner.nextLine();

    // Create Customer object
    Customer customer = new Customer(
      customerOrderNumber, customerName, customerContactNumber, customerLocation, customerEmail
    );

    // Prompt user to enter restaurant details
    System.out.print("\n\nPlease enter restaurants details: \n\n");
    System.out.print("Name: ");
    String restaurantName = scanner.nextLine();
    System.out.print("Location: ");
    String restaurantLocation = scanner.nextLine();
    System.out.print("Contact Number: ");
    String restaurantContactNumber = scanner.nextLine();
    System.out.print(
      "List of meals ordered, how many meals and their prices: (Separate using commas) "
      + "(Format example: 2 x Burger (R95.00):  "
    );
    String mealsAndPrices = scanner.nextLine();
    System.out.print("Special preparation instructions: ");
    String instructions = scanner.nextLine();

    // Create restaurant object
    Restaurant restaurant = new Restaurant(
      restaurantName, restaurantLocation, restaurantContactNumber, mealsAndPrices, instructions
    );

    // Read drivers from the file
    List<Driver> drivers = DriverManager.readDrivers();

    // Check for delivery availability
    Driver bestDriver = DriverManager.findDriverWithSmallestLoad(
      drivers, restaurantLocation
    );

    // Check for delivery availability
    if (bestDriver == null) {
      System.out.println(
        "Sorry! Our drivers are too far away from you to be able to deliver to your location."
      );
    } else {
      // Display customer details and order information
      System.out.println(customer.toString());
      System.out.println(
        "You have ordered the following from " + restaurantName + " in " + restaurantLocation
        + ":\n\n" + mealsAndPrices
      );
      System.out.println("\n\nSpecial instructions: " + instructions);
      System.out.println(
        "\n\nTotal: " + "R" + Restaurant.calculateTotalAmount(mealsAndPrices)
      );
      System.out.println(
        "\n\n" + bestDriver + " is nearest to the restaurant and so he will be delivering "
        + "your order to you at: \n\n" + customerAddress + "\n" + customerLocation
      );
      System.out.println(
        "\n\nIf you need to contact the restaurant, their number is " + restaurantContactNumber
      );
    }

    try {
      // Create a FileWriter object to write to the output file
      FileWriter writer = new FileWriter(new File("invoice.txt"));

      if (bestDriver == null) {
        // Write delivery unavailability message to file
        writer.write(
          "Sorry! Our drivers are too far away from you to be able to deliver to your location.\n"
        );
      } else {
        // Write customer details, order information, and delivery details to file
        writer.write(customer.toString() + "\n");
        writer.write(
          "You have ordered the following from " + restaurantName + " in " + restaurantLocation
          + ":\n\n" + mealsAndPrices + "\n"
        );
        writer.write("Special instructions: " + instructions + "\n");
        writer.write(
          "Total: " + Restaurant.calculateTotalAmount(mealsAndPrices) + "\n"
        );
        writer.write(
          bestDriver + " is nearest to the restaurant and so he will be delivering "
          + "your order to you at: \n\n" + customerAddress + "\n" + customerLocation + "\n"
        );
        writer.write(
          "If you need to contact the restaurant, their number is " + restaurantContactNumber + "\n"
        );
      }
      // Close the writer after writing
      writer.close();

      System.out.println("Output has been written to invoice.txt");
    } catch (IOException e) {
      // Handle IOException
      System.err.println("An error occurred while writing to the output file.");
    }
  }
}

