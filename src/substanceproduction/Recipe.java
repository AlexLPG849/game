public class Recipe {
    private String name;
    private int requiredSkill;
    private int basePurity;
    private int baseDanger;

    public Recipe(String name, int requiredSkill, int basePurity, int baseDanger) {
        this.name = name;
        this.requiredSkill = requiredSkill;
        this.basePurity = basePurity;
        this.baseDanger = baseDanger;
    }

    public String getName() {
        return name;
    }

    public int getRequiredSkill() {
        return requiredSkill;
    }

    public int getBasePurity() {
        return basePurity;
    }

    public int getBaseDanger() {
        return baseDanger;
    }
}