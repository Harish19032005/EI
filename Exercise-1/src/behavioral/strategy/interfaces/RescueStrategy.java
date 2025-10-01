package behavioral.strategy.interfaces;

public interface RescueStrategy {
    String getName();
    String execute(int distance, int fuel, int timeLimit);
}
