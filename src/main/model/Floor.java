package src.main.model;

import java.util.*;

public class Floor {
    private final int floorNumber;
    private final int capacity;
    private final List<VehicleSpace> spaces;

    public Floor(int floorNumber, int capacity) {
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.spaces = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            spaces.add(new VehicleSpace(i));
        }
    }

    public boolean addVehicle(Vehicle vehicle) {
        for (VehicleSpace space : spaces) {
            if (space.isAvailable()) {
                space.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean removeVehicle(String regNumber) {
        for (VehicleSpace space : spaces) {
            if (!space.isAvailable() && space.getVehicle().getRegistrationNumber().equals(regNumber)) {
                space.removeVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayStatus() {
        System.out.println("Floor " + floorNumber + ":");
        for (VehicleSpace space : spaces) {
            System.out.println(space);
        }
    }
}
