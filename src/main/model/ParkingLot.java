package src.main.model;

import java.util.*;

import src.main.strategy.CostStrategy;

public class ParkingLot {
    private final int numFloors;
    private final int spacesPerFloor;
    private final List<Floor> floors;
    private CostStrategy costStrategy;

    public ParkingLot(int numFloors, int spacesPerFloor) {
        this.numFloors = numFloors;
        this.spacesPerFloor = spacesPerFloor;
        this.floors = new ArrayList<>();

        for (int i = 1; i <= numFloors; i++) {
            floors.add(new Floor(i, spacesPerFloor));
        }
    }

    public void setCostStrategy(CostStrategy costStrategy) {
        this.costStrategy = costStrategy;
    }

    public void addVehicle(String type, String regNumber, String color) {
        for (Floor floor : floors) {
            if (floor.addVehicle(new Vehicle(type, regNumber, color))) {
                System.out.println("Vehicle added successfully: " + regNumber);
                return;
            }
        }
        throw new RuntimeException("Parking lot is full.");
    }

    public void removeVehicle(String regNumber) {
        for (Floor floor : floors) {
            if (floor.removeVehicle(regNumber)) {
                System.out.println("Vehicle removed successfully: " + regNumber);
                return;
            }
        }
        System.out.println("Vehicle not found: " + regNumber);
    }

    public void displayStatus() {
        for (Floor floor : floors) {
            floor.displayStatus();
        }
    }
}
