package src.main;

import java.util.Scanner;

import src.main.model.*;
import src.main.strategy.CostStrategy;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // System.out.print("Enter total number of floors: ");
        // int numFloors = sc.nextInt();

        // System.out.print("Enter space per floor: ");
        // int spacesPerFloor = sc.nextInt();

        // Initializing parking lot (I did it with 1 floor and 2 cars)
        ParkingLot parkingLot = new ParkingLot(1, 2);

        // Configuring cost strategy
        CostStrategy costStrategy = new CostStrategy();
        costStrategy.addCost("Bike", 10);
        costStrategy.addCost("Car", 20);
        costStrategy.addCost("Truck", 30);

        parkingLot.setCostStrategy(costStrategy);

        // Adding vehicles
        parkingLot.addVehicle("Bike", "KA-03-EF-8989", "Brown");
        parkingLot.addVehicle("Car", "KA-01-AB-1234", "Pink");


        // Attempting to add a 5th car (should throw an error)
        try {
            parkingLot.addVehicle("Truck", "KA-03-EF-6789", "Red");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Remove a vehicle by token
        parkingLot.removeVehicle("KA-01-AB-1234");

        // Display the status
        parkingLot.displayStatus();

        sc.close();
    }
}
