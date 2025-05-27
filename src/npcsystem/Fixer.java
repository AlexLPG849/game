public class Fixer extends NPC {
    private int cleanupCost;
    private List<String> services;
    private boolean leavesEvidence;

    public Fixer(String name, int age, String affiliation, String location) {
        super(name, age, affiliation, location);
        this.cleanupCost = 1000;
        this.services = new ArrayList<>();
        this.leavesEvidence = false;
    }

    public void addService(String service) {
        services.add(service);
    }

    public void performService(String service) {
        if (services.contains(service)) {
            System.out.println(name + " performs: " + service + " ($" + cleanupCost + ")");
        } else {
            System.out.println(name + ": 'I don’t do that.'");
        }
    }

    public void setLeavesEvidence(boolean flag) {
        leavesEvidence = flag;
    }

    @Override
    public void interact() {
        System.out.println(name + ": 'Got a problem? I can make it disappear... for a price.'");
        for (String s : services) {
            System.out.println("- Service: " + s);
        }
    }
}