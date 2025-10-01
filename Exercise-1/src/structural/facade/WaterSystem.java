package structural.facade;

import common.logging.AppLogger;

public class WaterSystem {
    public void start() {
        AppLogger.info("Water circulation system started.");
    }
    public void stop() {
        AppLogger.info("Water circulation system stopped.");
    }
}
