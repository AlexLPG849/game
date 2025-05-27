public class GameConfig {
    public static final int STARTING_CASH = 5000;
    public static final int MAX_HEAT = 100;
    public static final boolean DEBUG_MODE = false;

    public static void printConfig() {
        System.out.println("=== Game Config ===");
        System.out.println("Starting Cash: $" + STARTING_CASH);
        System.out.println("Max Heat: " + MAX_HEAT);
        System.out.println("Debug Mode: " + DEBUG_MODE);
    }
}