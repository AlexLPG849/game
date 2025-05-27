public class HeatSystem {
    private int heatLevel; // 0–100
    private final int MAX_HEAT = 100;

    public HeatSystem() {
        this.heatLevel = 0;
    }

    public int getHeatLevel() {
        return heatLevel;
    }

    public void increaseHeat(int amount) {
        heatLevel += amount;
        if (heatLevel > MAX_HEAT) heatLevel = MAX_HEAT;
        System.out.println("Heat increased to " + heatLevel + "/100.");
    }

    public void decreaseHeat(int amount) {
        heatLevel -= amount;
        if (heatLevel < 0) heatLevel = 0;
        System.out.println("Heat decreased to " + heatLevel + "/100.");
    }

    public boolean isTooHot() {
        return heatLevel >= 70;
    }

    public void applyHeatEffect(NPC npc) {
        if (isTooHot()) {
            npc.setSurveillance(true);
            npc.setDangerLevel(npc.getDangerLevel() + 20);
            System.out.println(npc.getName() + " is now under surveillance due to heat.");
        }
    }
}