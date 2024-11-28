# **Parking Lot System Documentation**

## **Overview**
This document provides an overview, usage instructions, and details about the design of a Parking Lot System implemented in Core Java. The system is designed to manage vehicles in a parking lot with configurable cost strategies and multiple floors. It supports different vehicle types and provides methods to add, remove, and query vehicles.

---

## **Features**
1. **Initialization**: The parking lot can be initialized with a given number of floors and spaces per floor. Uncomment the code for taking numFloors and spacesPerFloor for passing input.
2. **Vehicle Management**: Add and remove vehicles, including cars, trucks, or other vehicle types.
3. **Availability Check**: Query available spaces by floor and vehicle type.
4. **Cost Strategy**: Configure different costs for each vehicle type, supporting flexible billing strategies.
5. **Status Display**: Display the current status of the parking lot, including available and occupied spaces.
6. **Token System**: A token is generated when a vehicle is parked, which can be used to calculate fees upon exit.



## **Classes and Methods**

### 1. **`ParkingLot`** (`model.ParkingLot`)
Manages the parking lot, including floors and cost strategies.

- **Attributes**:
  - `numFloors`: Number of floors.
  - `spacesPerFloor`: Number of spaces per floor.
  - `List<Floor>`: List of floors.
  - `CostStrategy`: The cost strategy for parking fees.

- **Methods**:
  - `addVehicle(String type, String regNumber, String color)`: Adds a vehicle to the lot.
  - `removeVehicle(String regNumber)`: Removes a vehicle based on registration number.
  - `displayStatus()`: Displays the parking lot's current status.
  - `setCostStrategy(CostStrategy strategy)`: Sets the cost calculation strategy.

---

### 2. **`Floor`** (`model.Floor`)
Represents a single floor in the parking lot.

- **Attributes**:
  - `floorNumber`: The floor's number.
  - `capacity`: Maximum number of vehicle spaces.
  - `List<VehicleSpace>`: List of vehicle spaces.

- **Methods**:
  - `addVehicle(Vehicle vehicle)`: Parks a vehicle in an available space.
  - `removeVehicle(String regNumber)`: Removes a vehicle by registration number.
  - `displayStatus()`: Prints the status of spaces on the floor.

---

### 3. **`Vehicle`** (`model.Vehicle`)
Represents a vehicle with relevant attributes.

- **Attributes**:
  - `type`: Type of vehicle (e.g., car, truck).
  - `registrationNumber`: Vehicle’s unique registration number.
  - `color`: Vehicle color.

---

### 4. **`VehicleSpace`** (`model.VehicleSpace`)
Represents a single parking space.

- **Attributes**:
  - `spaceNumber`: Space's identifier.
  - `vehicle`: The parked vehicle, if any.

- **Methods**:
  - `isAvailable()`: Checks if the space is free.
  - `parkVehicle(Vehicle vehicle)`: Assigns a vehicle to the space.
  - `removeVehicle()`: Removes the parked vehicle.
  - `toString()`: Displays space details.

---

### 5. **`CostStrategy`** (`strategy.CostStrategy`)
Implements flexible parking cost strategies.

- **Attributes**:
  - `Map<String, Integer> costMap`: Maps vehicle types to their hourly rates.

- **Methods**:
  - `addCost(String vehicleType, int costPerHour)`: Adds a cost for a vehicle type.
  - `getCost(String vehicleType)`: Retrieves the cost for a given vehicle type.

---

## **Usage Instructions**

### Step 1: Initialize Parking Lot
```java
ParkingLot parkingLot = new ParkingLot(2, 2); // 2 floors, 2 spaces per floor
```

### Step 2: Configure Cost Strategy
```java
CostStrategy costStrategy = new CostStrategy();
costStrategy.addCost("Car", 20);  // ₹20/hour for cars
costStrategy.addCost("Truck", 30); // ₹30/hour for trucks
parkingLot.setCostStrategy(costStrategy);
```

### Step 3: Add Vehicles
```java
parkingLot.addVehicle("Car", "KA-01-AB-1234", "Red");
parkingLot.addVehicle("Car", "KA-02-CD-5678", "Blue");
```

### Step 4: Display Status
```java
parkingLot.displayStatus();
```

### Step 5: Remove Vehicles
```java
parkingLot.removeVehicle("KA-01-AB-1234");
```

---

## **Error Handling**
- **Full Parking Lot**: Throws a `RuntimeException` with the message "Parking lot is full."
- **Vehicle Not Found**: Prints a message if a vehicle cannot be located for removal.

---

## **Example Output**
```
Vehicle added successfully: KA-01-AB-1234
Vehicle added successfully: KA-02-CD-5678
Parking lot is full.
Floor 1:
Space 1: Occupied by Car - KA-01-AB-1234 (Red)
Space 2: Occupied by Car - KA-02-CD-5678 (Blue)
Vehicle removed successfully: KA-01-AB-1234
```

---

## **Extensibility**
- **New Vehicle Types**: Easily add new vehicle types by updating the `CostStrategy` configuration.
- **Flexible Cost Strategies**: The system supports switching to new pricing models without changing core functionality.

---

## **Testing Scenarios**
- **Add Vehicles**: Test adding multiple vehicles of various types.
- **Remove Vehicles**: Test removing vehicles by registration number.
- **Full Lot**: Attempt to add vehicles when the lot is full and observe the error.
- **Cost Calculation**: Verify the cost for different vehicle types.