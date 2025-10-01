package common.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppLogger {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static String timestamp() {
        return LocalDateTime.now().format(formatter);
    }

    public static void info(String message) {
        System.out.println("[INFO ] " + timestamp() + " - " + message);
    }

    public static void error(String message) {
        System.err.println("[ERROR] " + timestamp() + " - " + message);
    }

    public static void warning(String message) {
        System.out.println("[WARN ] " + timestamp() + " - " + message);
    }

    public static void debug(String message) {
        // You can toggle this with a flag if needed
        System.out.println("[DEBUG] " + timestamp() + " - " + message);
    }
}
