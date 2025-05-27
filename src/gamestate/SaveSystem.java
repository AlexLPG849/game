public class SaveSystem {
    private static final String SAVE_FILE = "savegame.dat";

    public static void save(Player player) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            out.writeObject(player);
            System.out.println("Game saved.");
        } catch (IOException e) {
            System.out.println("Save failed: " + e.getMessage());
        }
    }

    public static Player load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            Player player = (Player) in.readObject();
            System.out.println("Game loaded.");
            return player;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Load failed: " + e.getMessage());
            return null;
        }
    }
}