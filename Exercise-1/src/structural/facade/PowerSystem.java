package structural.facade;

import common.logging.AppLogger;

public class PowerSystem {
    public void start() {
        AppLogger.info("Power grid activated.");
    }
    public void stop() {
        AppLogger.info("Power grid shut down.");
    }
}
