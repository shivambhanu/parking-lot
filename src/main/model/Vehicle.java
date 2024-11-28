package src.main.model;

public class Vehicle {
    private final String type;
    private final String registrationNumber;
    private final String color;

    public Vehicle(String type, String registrationNumber, String color) {
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        return type + " - " + registrationNumber + " (" + color + ")";
    }
}
