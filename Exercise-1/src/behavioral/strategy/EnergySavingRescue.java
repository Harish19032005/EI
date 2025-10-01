package behavioral.strategy;

import behavioral.strategy.interfaces.RescueStrategy;
import common.logging.AppLogger;

public class EnergySavingRescue implements RescueStrategy {
    @Override
    public String getName() {
        return "Energy-Saving Rescue";
    }

    @Override
    public String execute(int distance, int fuel, int timeLimit) {
        int fuelNeeded = distance; // most fuel-efficient
        int timeTaken = distance * 2; // very slow

        if (fuel < fuelNeeded) {
            AppLogger.warning("Energy-Saving Rescue failed: insufficient fuel.");
            return "Mission Failed: Not enough fuel.";
        }
        if (timeTaken > timeLimit) {
            AppLogger.warning("Energy-Saving Rescue failed: time limit exceeded.");
            return "Mission Failed: Time limit exceeded.";
        }
        AppLogger.info("Energy-Saving Rescue succeeded.");
        return "Mission Success via Energy-Saving Rescue!";
    }
}
