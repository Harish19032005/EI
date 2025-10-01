package structural.composite;

import structural.composite.interfaces.Resource;
import common.logging.AppLogger;

public class Food implements Resource {
    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return "Food";
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void showDetails() {
        AppLogger.info("Resource: Food | Quantity: " + quantity);
    }
}
