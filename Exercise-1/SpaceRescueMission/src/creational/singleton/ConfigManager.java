package creational.singleton;

import common.logging.AppLogger;

import java.util.HashMap;
import java.util.Map;

/**
 * ConfigManager is a Singleton class that ensures only one instance
 * exists across the application. It simulates loading and storing configuration
 * settings for the space mission.
 */
public class ConfigManager {

    private static ConfigManager instance;
    private final Map<String, String> configs = new HashMap<>();

    // private constructor prevents external instantiation
    private ConfigManager() {
        AppLogger.info("Loading configuration settings...");
        configs.put("mission", "Mars Rescue");
        configs.put("maxCrew", "5");
        configs.put("fuelCapacity", "1000");
    }

    // Thread-safe Singleton accessor (Double-Checked Locking)
    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }

    public String getConfig(String key) {
        return configs.get(key);
    }

    public void setConfig(String key, String value) {
        configs.put(key, value);
        AppLogger.info("Config updated: " + key + " = " + value);
    }

    public void showAllConfigs() {
        AppLogger.info("Current configurations: " + configs);
    }
}
