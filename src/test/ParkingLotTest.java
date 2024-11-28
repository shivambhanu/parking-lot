package src.test;

import src.main.model.ParkingLot;
import src.main.model.Vehicle;
import src.main.strategy.CostStrategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    public void testInitializeParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2, 3);
        assertEquals(2, parkingLot.getNumFloors());
        assertEquals(3, parkingLot.getSpacesPerFloor());
    }

    @Test
    public void testAddVehicle() {
        ParkingLot parkingLot = new ParkingLot(1, 2);
        parkingLot.addVehicle("Car", "KA-01-AB-1234", "Red");
        assertEquals(1, parkingLot.getOccupiedSpaces("Car", 1));
    }

    @Test
    public void testFullParkingLotError() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        parkingLot.addVehicle("Car", "KA-01-AB-1234", "Red");
        Exception exception = assertThrows(RuntimeException.class, () -> {
            parkingLot.addVehicle("Car", "KA-02-CD-5678", "Blue");
        });
        assertEquals("Parking lot is full.", exception.getMessage());
    }

    @Test
    public void testRemoveVehicle() {
        ParkingLot parkingLot = new ParkingLot(1, 2);
        parkingLot.addVehicle("Car", "KA-01-AB-1234", "Red");
        parkingLot.removeVehicle("KA-01-AB-1234");
        assertEquals(0, parkingLot.getOccupiedSpaces("Car", 1));
    }
}

