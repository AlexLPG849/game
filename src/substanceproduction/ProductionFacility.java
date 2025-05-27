public class ProductionFacility {
    private String name;
    private int basePurity;
    private int productionSkill;
    private List<Substance> inventory;

    public ProductionFacility(String name, int basePurity, int productionSkill) {
        this.name = name;
        this.basePurity = basePurity;
        this.productionSkill = productionSkill;
        this.inventory = new ArrayList<>();
    }

    public Substance produce(String substanceName, int units) {
        int finalPurity = Math.min(100, basePurity + (productionSkill / 2));
        int value = finalPurity * 2; // Market value = $2 x purity
        int risk = (finalPurity > 80) ? 40 : 20;

        Substance s = new Substance(substanceName, finalPurity, value, risk, true);
        for (int i = 0; i < units; i++) {
            inventory.add(s);
        }

        System.out.println("Produced " + units + " units of " + substanceName + " at " + finalPurity + "% purity.");
        return s;
    }

    public List<Substance> getInventory() {
        return inventory;
    }
}