public class Client extends NPC {
    private int satisfactionLevel;
    private List<String> purchaseHistory;
    private boolean talksToCops;

    public Client(String name, int age, String affiliation, String location) {
        super(name, age, affiliation, location);
        this.satisfactionLevel = 50;
        this.purchaseHistory = new ArrayList<>();
        this.talksToCops = false;
    }

    public void buyProduct(String product) {
        System.out.println(name + " buys: " + product);
        satisfactionLevel += 10;
        gainTrust(5);
        purchaseHistory.add(product);
    }

    public void complain() {
        System.out.println(name + " complains: 'This batch ain't right...'");
        satisfactionLevel -= 15;
        loseTrust(10);
    }

    public int getSatisfactionLevel() {
        return satisfactionLevel;
    }

    public void reportToCops() {
        if (satisfactionLevel < 20 && loyalty < 30) {
            talksToCops = true;
            System.out.println(name + " reports you to the authorities...");
        } else {
            System.out.println(name + " refuses to snitch... for now.");
        }
    }

    @Override
    public void interact() {
        if (talksToCops) {
            System.out.println(name + " looks away. You've been burned.");
        } else if (satisfactionLevel >= 60) {
            System.out.println(name + ": 'You're reliable. I’ll stick with you.'");
        } else {
            System.out.println(name + ": 'Don't mess up again.'");
        }
    }
}