package src.main.model;

public class VehicleSpace {
    private final int spaceNumber;
    private Vehicle vehicle;

    public VehicleSpace(int spaceNumber) {
        this.spaceNumber = spaceNumber;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void removeVehicle() {
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "Space " + spaceNumber + ": " + (vehicle == null ? "Available" : "Occupied by " + vehicle);
    }
}
