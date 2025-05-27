public class ProgressionSystem {
    private int xp;
    private int level;

    public ProgressionSystem() {
        this.xp = 0;
        this.level = 1;
    }

    public void gainXP(int amount) {
        xp += amount;
        while (xp >= xpToLevel()) {
            xp -= xpToLevel();
            level++;
            System.out.println("You reached level " + level + "!");
        }
    }

    private int xpToLevel() {
        return 100 + (level * 20);
    }

    public void display() {
        System.out.println("Level: " + level + " | XP: " + xp + "/" + xpToLevel());
    }

    public int getLevel() {
        return level;
    }
}