package behavioral.strategy;

import behavioral.strategy.interfaces.RescueStrategy;
import common.logging.AppLogger;

public class StealthRescue implements RescueStrategy {
    @Override
    public String getName() {
        return "Stealth Rescue";
    }

    @Override
    public String execute(int distance, int fuel, int timeLimit) {
        int fuelNeeded = (int) (distance * 1.5); // more efficient than direct
        int timeTaken = distance; // slower due to stealth mode

        if (fuel < fuelNeeded) {
            AppLogger.warning("Stealth Rescue failed: insufficient fuel.");
            return "Mission Failed: Not enough fuel.";
        }
        if (timeTaken > timeLimit) {
            AppLogger.warning("Stealth Rescue failed: time limit exceeded.");
            return "Mission Failed: Time limit exceeded.";
        }
        AppLogger.info("Stealth Rescue succeeded.");
        return "Mission Success via Stealth Rescue!";
    }
}
