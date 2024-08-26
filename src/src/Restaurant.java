package src;

class Restaurant {
  // Attributes of Restaurant class.
  private String restaurantName;
  private String restaurantLocation;
  private String restaurantContactNumber;
  private String mealsAndPrices;
  private String instructions;

  // Constructor for Restaurant class.
  public Restaurant(String name, String location, String contactNumber, 
      String mealsAndPrices, String instructions) {
    this.restaurantName = name;
    this.restaurantLocation = location;
    this.restaurantContactNumber = contactNumber;
    this.mealsAndPrices = mealsAndPrices;
    this.instructions = instructions;
  }

  // Method to get name.
  public String getRestaurantName() {
    return restaurantName;
  }

  // Method to get location.
  public String getRestaurantLocation() {
    return restaurantLocation;
  }

  // Method to get contact number.
  public String getRestaurantContactNumber() {
    return restaurantContactNumber;
  }

  // Method to get meals and prices.
  public String getMealsAndPrices() {
    return mealsAndPrices;
  }

  // Method to get instructions.
  public String getInstructions() {
    return instructions;
  }
  
  @Override
  // toString method to show object.
  public String toString() {
    String output = "Name: " + restaurantName + "\n";
    output += "Location: " + restaurantLocation + "\n";
    output += "Contact Number: " + restaurantContactNumber + "\n";
    output += "Meals and Prices: " + mealsAndPrices + "\n";
    output += "Instructions: " + instructions + "\n";
    return output;
  }

  // Method to calculate the total amount.
  public static double calculateTotalAmount(String mealsAndPrices) {
    // Initialise sum.
    double sum = 0;
    
    // Check if the input string is null and return sum if null.
    if (mealsAndPrices == null) {
      return sum;
    }

    // Split input string by commas.
    String[] items = mealsAndPrices.split("[,]+");
    
    for (String item : items) {
      try {
        // Trim whitespace split by x to separate prices.
        String[] parts = item.trim().split(" x ");
        
        // Check if the item is in the format "quantity x price"
        if (parts.length == 2) {
          // Get quantity and convert to integer.
          int quantity = Integer.parseInt(parts[0].trim());
          
          // Get price, remove non-numbers and convert to double.
          double price = Double.parseDouble(parts[1].replaceAll("[^0-9.]", ""));
          
          // Calculate total cost.
          sum += quantity * price;
        } else {
          // Remove non-numbers, convert to double and add it to sum.
          double price = Double.parseDouble(item.replaceAll("[^0-9.]", ""));
          sum += price;
        }
      } catch (NumberFormatException e) {
        // Handle error if parsing fails for an item.
        System.err.println("Error parsing item: " + item);
      }
    }
    
    // Return the total sum.
    return sum;
  }
}
