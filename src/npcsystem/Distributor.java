public class Distributor extends NPC {
    private int cargoCapacity;
    private boolean atBorder;
    private List<String> tradeRoutes;

    public Distributor(String name, int age, String affiliation, String location) {
        super(name, age, affiliation, location);
        this.cargoCapacity = 100;
        this.atBorder = false;
        this.tradeRoutes = new ArrayList<>();
    }

    public void addRoute(String route) {
        tradeRoutes.add(route);
    }

    public void deliver() {
        System.out.println(name + " is moving product across route. Cargo: " + cargoCapacity + " units.");
    }

    public void setBorderStatus(boolean flag) {
        atBorder = flag;
    }

    @Override
    public void interact() {
        if (atBorder) {
            System.out.println(name + ": 'Customs heat is real. We need to reroute.'");
        } else {
            System.out.println(name + ": 'Let’s move weight. You in or out?'");
        }
    }
}