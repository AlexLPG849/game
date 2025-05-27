public class StressSystem {
    private int stress; // 0–100

    public StressSystem() {
        this.stress = 0;
    }

    public void addStress(int amount) {
        stress += amount;
        if (stress > 100) stress = 100;
    }

    public void reduceStress(int amount) {
        stress -= amount;
        if (stress < 0) stress = 0;
    }

    public boolean canFailAction() {
        return stress >= 75 && Math.random() < 0.3;
    }

    public void display() {
        System.out.println("Stress Level: " + stress + "/100");
    }

    public int getStress() {
        return stress;
    }
}