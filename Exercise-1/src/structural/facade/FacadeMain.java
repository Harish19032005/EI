package structural.facade;

import common.logging.AppLogger;

public class FacadeMain {
    public static void main(String[] args) {
        AppLogger.info("--- Colony Life Support (Facade Pattern) ---");

        LifeSupportFacade lifeSupport = new LifeSupportFacade();

        lifeSupport.startLifeSupport();
        AppLogger.info("Colony systems running...");

        // simulate shutdown
        lifeSupport.stopLifeSupport();
    }
}
