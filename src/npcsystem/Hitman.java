public class Hitman extends NPC {
    private int successRate;
    private int fee;
    private boolean doubleAgent;
    private String preferredWeapon;

    public Hitman(String name, int age, String affiliation, String location) {
        super(name, age, affiliation, location);
        this.successRate = 85;
        this.fee = 5000;
        this.doubleAgent = false;
        this.preferredWeapon = "Silenced Pistol";
    }

    public void assignTarget(String target) {
        System.out.println(name + ": 'Target acquired – " + target + ".' Fee: $" + fee);
    }

    public void betray() {
        doubleAgent = true;
        System.out.println(name + " flips sides. You've been set up.");
    }

    @Override
    public void interact() {
        if (doubleAgent) {
            System.out.println(name + ": 'Nothing personal. Just business.'");
        } else {
            System.out.println(name + ": 'Pick a name. I’ll handle the rest.'");
        }
    }
}