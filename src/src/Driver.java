package src;

class Driver {
  // Attributes of Driver class.
  private String driverName;
  private String driverLocation;
  private int driverLoad;
  
  // Constructor for Driver class.
  public Driver(String name, String location, int load) {
    this.driverName = name;
    this.driverLocation = location;
    this.driverLoad = load;
  }
  
  // Method to get name.
  public String getDriverName() {
    return driverName;
  }
  
  // Method to get location.
  public String getDriverLocation() {
    return driverLocation;
  }
  
  // Method to get load.
  public int getDriverLoad() {
    return driverLoad;
  }
  
  @Override
  // toString method to display object.
  public String toString() {
    return driverName;
  }
}
