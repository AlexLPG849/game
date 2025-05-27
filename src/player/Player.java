public class Player implements Serializable {
    private String name;
    private int cash;
    private int heat;
    private int globalReputation;
    private Map<String, Integer> factionReputation;
    private InventorySystem inventory;

    public Player(String name) {
        this.name = name;
        this.cash = 5000;
        this.heat = 0;
        this.globalReputation = 50;
        this.factionReputation = new HashMap<>();
        this.inventory = new InventorySystem();
    }

    public void addCash(int amount) {
        cash += amount;
        System.out.println("Gained $" + amount + " | Total: $" + cash);
    }

    public boolean spendCash(int amount) {
        if (amount > cash) {
            System.out.println("Not enough cash.");
            return false;
        }
        cash -= amount;
        return true;
    }

    public void adjustHeat(int amount) {
        heat += amount;
        if (heat < 0) heat = 0;
        System.out.println("Heat level: " + heat + "/100");
    }

    public void adjustReputation(String faction, int delta) {
        int current = factionReputation.getOrDefault(faction, 50);
        factionReputation.put(faction, Math.min(100, Math.max(0, current + delta)));
    }

    public int getFactionReputation(String faction) {
        return factionReputation.getOrDefault(faction, 50);
    }

    public InventorySystem getInventory() {
        return inventory;
    }

    public int getHeat() {
        return heat;
    }

    public int getCash() {
        return cash;
    }

    public String getName() {
        return name;
    }
}