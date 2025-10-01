package structural.composite;

import structural.composite.interfaces.Resource;
import common.logging.AppLogger;

public class Water implements Resource {
    private int quantity;

    public Water(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return "Water";
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void showDetails() {
        AppLogger.info("Resource: Water | Quantity: " + quantity);
    }
}
