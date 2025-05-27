public class NPCBehavior {
    private int paranoia;      // 0–100
    private int aggression;    // 0–100
    private int loyalty;       // 0–100
    private boolean volatileMood;

    public NPCBehavior() {
        this.paranoia = 30;
        this.aggression = 20;
        this.loyalty = 50;
        this.volatileMood = false;
    }

    public void tickBehavior() {
        if (volatileMood) {
            paranoia += random(-5, 10);
            aggression += random(-10, 15);
        } else {
            paranoia += random(-2, 2);
            aggression += random(-3, 3);
        }
        clamp();
    }

    public void influenceByHeat(int heatLevel) {
        paranoia += heatLevel / 10;
        if (heatLevel > 70) volatileMood = true;
        clamp();
    }

    public void applyTrustChange(int trustChange) {
        loyalty += trustChange;
        if (trustChange < 0) aggression += Math.abs(trustChange) / 2;
        clamp();
    }

    public boolean willSnap() {
        return aggression > 80 || paranoia > 90;
    }

    private int random(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    private void clamp() {
        paranoia = Math.min(100, Math.max(0, paranoia));
        aggression = Math.min(100, Math.max(0, aggression));
        loyalty = Math.min(100, Math.max(0, loyalty));
    }

    public void display() {
        System.out.println("Behavior - Loyalty: " + loyalty + " | Aggression: " + aggression + " | Paranoia: " + paranoia);
    }
}