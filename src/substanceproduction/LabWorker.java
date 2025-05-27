public class LabWorker {
    private String name;
    private int skillLevel;

    public LabWorker(String name, int skillLevel) {
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public Substance craft(Recipe recipe) {
        if (skillLevel < recipe.getRequiredSkill()) {
            System.out.println(name + " fails to properly cook " + recipe.getName());
            return null;
        }

        int finalPurity = recipe.getBasePurity() + (skillLevel / 2);
        int market = finalPurity * 2;
        Substance s = new Substance(recipe.getName(), finalPurity, market, recipe.getBaseDanger(), true);
        System.out.println(name + " successfully produced " + s.getName() + " at " + finalPurity + "% purity.");
        return s;
    }
}