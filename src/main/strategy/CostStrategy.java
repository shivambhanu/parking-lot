package src.main.strategy;

import java.util.HashMap;
import java.util.Map;

public class CostStrategy {
    private final Map<String, Integer> costMap = new HashMap<>();

    public void addCost(String vehicleType, int costPerHour) {
        costMap.put(vehicleType, costPerHour);
    }

    public int getCost(String vehicleType) {
        return costMap.getOrDefault(vehicleType, 0);
    }
}
