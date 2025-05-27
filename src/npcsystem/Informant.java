public class Informant extends NPC {
    private boolean flipped;
    private int payoffDemand;
    private String handler;
    private int exposureRisk;

    public Informant(String name, int age, String affiliation, String location) {
        super(name, age, affiliation, location);
        this.flipped = false;
        this.payoffDemand = 2000;
        this.handler = "Unknown";
        this.exposureRisk = 40;
    }

    public void flip(String handlerName) {
        this.flipped = true;
        this.handler = handlerName;
        System.out.println(name + " has flipped. Handler: " + handler);
    }

    public void demandPayoff() {
        System.out.println(name + ": 'I stay quiet for $" + payoffDemand + ". Take it or leave it.'");
    }

    @Override
    public void interact() {
        if (flipped) {
            System.out.println(name + ": 'You better hope they don’t find out I’m feeding them info.'");
        } else {
            System.out.println(name + ": 'I got dirt. But what’s in it for me?'");
        }
    }
}