public class FactionManager {
    private Map<String, Integer> factionLoyalty; // e.g. "Cartel" -> 65

    public FactionManager() {
        this.factionLoyalty = new HashMap<>();
    }

    public void setLoyalty(String faction, int amount) {
        factionLoyalty.put(faction, amount);
    }

    public void adjustLoyalty(String faction, int delta) {
        factionLoyalty.put(faction, factionLoyalty.getOrDefault(faction, 50) + delta);
    }

    public int getLoyalty(String faction) {
        return factionLoyalty.getOrDefault(faction, 50);
    }

    public void showFactions() {
        System.out.println("Faction Loyalty Levels:");
        for (String f : factionLoyalty.keySet()) {
            System.out.println("- " + f + ": " + factionLoyalty.get(f));
        }
    }

    public boolean isHostile(String faction) {
        return getLoyalty(faction) <= 20;
    }
}