package src;

class Customer { 
  // Attributes of Customer class.
  private int customerOrderNumber;
  private String customerName;
  private String customerContactNumber;
  private String customerLocation;
  private String customerEmail;
  
  // Constructor for Customer class.
  public Customer(int customerOrderNumber, String customerName, 
      String customerContactNumber, String customerLocation, 
      String customerEmail) {
    this.customerOrderNumber = customerOrderNumber;
    this.customerName = customerName;
    this.customerContactNumber = customerContactNumber;
    this.customerLocation = customerLocation;
    this.customerEmail = customerEmail;
  }
  
  // Method to get order number.
  public int getCustomerOrderNumber() {
    return customerOrderNumber;
  }
  
  // Method to get name.
  public String getCustomerName() {
    return customerName;
  }
  
  // Method to get contact number.
  public String getCustomerContactNumber() {
    return customerContactNumber;
  }
  
  // Method to get location.
  public String getCustomerLocation() {
    return customerLocation;
  }
  
  // Method to get email.
  public String getCustomerEmail() {
    return customerEmail;
  }
  
  @Override
  // toString method to show object.
  public String toString() {
    String output = "Order Number " + customerOrderNumber + "\n";
    output += "Customer: " + customerName + "\n";
    output += "Contact Number: " + customerContactNumber + "\n";
    output += "Location: " + customerLocation + "\n";
    output += "Email: " + customerEmail + "\n";
    return output;
  }
}





    