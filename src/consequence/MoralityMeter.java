public class MoralityMeter {
    private int morality; // 0 = evil, 100 = good

    public MoralityMeter() {
        morality = 50;
    }

    public void change(int amount) {
        morality += amount;
        if (morality > 100) morality = 100;
        if (morality < 0) morality = 0;
    }

    public String getAlignment() {
        if (morality >= 75) return "Righteous";
        if (morality >= 50) return "Neutral";
        if (morality >= 25) return "Corrupt";
        return "Depraved";
    }

    public int getMorality() {
        return morality;
    }

    public void display() {
        System.out.println("Morality: " + morality + " (" + getAlignment() + ")");
    }
}