package behavioral.strategy;

import behavioral.strategy.interfaces.RescueStrategy;

public class MissionContext {
    private RescueStrategy strategy;

    public void setStrategy(RescueStrategy strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy(int distance, int fuel, int timeLimit) {
        if (strategy == null) {
            return "No strategy selected.";
        }
        return strategy.execute(distance, fuel, timeLimit);
    }

    public String getCurrentStrategyName() {
        return (strategy == null) ? "None" : strategy.getName();
    }
}
