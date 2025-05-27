public class ReputationSystem {
    private Map<String, Integer> factionReputation;

    public ReputationSystem() {
        this.factionReputation = new HashMap<>();
    }

    public void setRep(String faction, int value) {
        factionReputation.put(faction, Math.max(0, Math.min(100, value)));
    }

    public void adjustRep(String faction, int delta) {
        int current = factionReputation.getOrDefault(faction, 50);
        setRep(faction, current + delta);
    }

    public int getRep(String faction) {
        return factionReputation.getOrDefault(faction, 50);
    }

    public void displayReputation() {
        System.out.println("=== Faction Reputation ===");
        for (Map.Entry<String, Integer> e : factionReputation.entrySet()) {
            System.out.println("- " + e.getKey() + ": " + e.getValue());
        }
    }
}