package behavioral.strategy;

import behavioral.strategy.interfaces.RescueStrategy;
import common.logging.AppLogger;

public class DirectRescue implements RescueStrategy {
    @Override
    public String getName() {
        return "Direct Rescue";
    }

    @Override
    public String execute(int distance, int fuel, int timeLimit) {
        int fuelNeeded = distance * 2; // fast but fuel-heavy
        int timeTaken = distance / 2;  // faster travel

        if (fuel < fuelNeeded) {
            AppLogger.warning("Direct Rescue failed: insufficient fuel.");
            return "Mission Failed: Not enough fuel.";
        }
        if (timeTaken > timeLimit) {
            AppLogger.warning("Direct Rescue failed: time limit exceeded.");
            return "Mission Failed: Time limit exceeded.";
        }
        AppLogger.info("Direct Rescue succeeded.");
        return "Mission Success via Direct Rescue!";
    }
}
