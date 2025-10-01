package structural.composite;

import structural.composite.interfaces.Resource;
import common.logging.AppLogger;

public class Medicine implements Resource {
    private int quantity;

    public Medicine(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return "Medicine";
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void showDetails() {
        AppLogger.info("Resource: Medicine | Quantity: " + quantity);
    }
}
