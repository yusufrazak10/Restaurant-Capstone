package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DriverManager {
  // Method to read drivers from a file and return a list of Driver objects.
  public static List<Driver> readDrivers() {
    // Create an ArrayList to store Driver objects
    List<Driver> drivers = new ArrayList<>();

    // Specify the input file name
    String inputFileName = "drivers.txt";

    try {
      // Initialize Scanner to read from the specified file
      Scanner fileScanner = new Scanner(new File(inputFileName));

      while (fileScanner.hasNextLine()) {
        // Read each line of the file
        String driverRead = fileScanner.nextLine();

        // Split the line into driver information
        String[] driverInfo = driverRead.split(", ");

        // Ensure the line has the correct format
        if (driverInfo.length == 3) {
          // Get driver information from the array
          String driverName = driverInfo[0];
          String driverLocation = driverInfo[1];
          int driverLoad = Integer.parseInt(driverInfo[2]);

          // Create a new Driver object
          Driver newDriver = new Driver(driverName, driverLocation, driverLoad);

          // Add the Driver object to the list
          drivers.add(newDriver);
        } else {
          // Print an error message if the line format is incorrect
          System.err.println("Line format error: " + driverRead);
        }
      }

      // Close the file scanner
      fileScanner.close();

    } catch (FileNotFoundException e) {
      // Handle the case where the file is not found
      System.err.println("Input file not found.");
    } catch (NumberFormatException e) {
      // Handle the case where the load is not a valid integer
      System.err.println("Error parsing driver load.");
    }

    // Return the list of Driver objects
    return drivers;
  }

  // Method to find the driver with the smallest load
  public static Driver findDriverWithSmallestLoad(
      List<Driver> drivers, String restaurantLocation) {
    // Initialize the bestDriver variable
    Driver bestDriver = null;

    // Iterate over each Driver object in the list
    for (Driver driver : drivers) {
      // Check if driver location matches restaurant location
      if (driver.getDriverLocation().equals(restaurantLocation)) {
        // If bestDriver is null or the current driver's load is smaller than
        // the bestDriver's load
        if (bestDriver == null
            || driver.getDriverLoad() < bestDriver.getDriverLoad()) {
          // Make bestDriver be the current driver
          bestDriver = driver;
        }
      }
    }

    // If no suitable driver was found
    if (bestDriver == null) {
      System.out.println(
          "Sorry! Our drivers are too far away from you to be able to deliver "
              + "to your location.");
    }

    // Return the driver with the smallest load, or null if no suitable driver
    // was found
    return bestDriver;
  }
}
