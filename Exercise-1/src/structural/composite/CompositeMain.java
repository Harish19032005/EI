package structural.composite;

import common.logging.AppLogger;

public class CompositeMain {
    public static void main(String[] args) {
        AppLogger.info("--- Colony Resource Management (Composite Pattern) ---");

        Food food = new Food(500);
        Water water = new Water(1000);
        Medicine medicine = new Medicine(200);

        ColonyResourceGroup storage = new ColonyResourceGroup("Storage Room");
        storage.addResource(food);
        storage.addResource(water);

        ColonyResourceGroup hospital = new ColonyResourceGroup("Hospital Wing");
        hospital.addResource(medicine);

        ColonyResourceGroup colony = new ColonyResourceGroup("Main Colony");
        colony.addResource(storage);
        colony.addResource(hospital);

        colony.showDetails();
    }
}
