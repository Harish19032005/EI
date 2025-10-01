package structural.facade;

import common.logging.AppLogger;

public class LifeSupportFacade {
    private OxygenSystem oxygen;
    private WaterSystem water;
    private PowerSystem power;

    public LifeSupportFacade() {
        this.oxygen = new OxygenSystem();
        this.water = new WaterSystem();
        this.power = new PowerSystem();
    }

    public void startLifeSupport() {
        AppLogger.info("Starting life support...");
        oxygen.start();
        water.start();
        power.start();
        AppLogger.info("Life support fully operational.");
    }

    public void stopLifeSupport() {
        AppLogger.info("Stopping life support...");
        oxygen.stop();
        water.stop();
        power.stop();
        AppLogger.info("Life support systems offline.");
    }
}
