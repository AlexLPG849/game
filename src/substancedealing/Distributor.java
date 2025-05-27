public class Distributor {
    private String routeName;
    private int riskLevel;
    private int capacity;

    public Distributor(String routeName, int riskLevel, int capacity) {
        this.routeName = routeName;
        this.riskLevel = riskLevel;
        this.capacity = capacity;
    }

    public void transport(Substance s, int quantity) {
        if (quantity > capacity) {
            System.out.println("Cannot move " + quantity + " units — exceeds capacity of " + capacity + ".");
            return;
        }

        int bustChance = s.getDangerLevel() + riskLevel;
        boolean busted = (Math.random() * 100) < bustChance;

        if (busted) {
            System.out.println("Shipment intercepted on route: " + routeName);
        } else {
            System.out.println("Successfully transported " + quantity + " units of " + s.getName() + " via " + routeName);
        }
    }
}