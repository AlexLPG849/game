public abstract class NPC extends Character {
    protected int streetRep;
    protected boolean isHostile;
    protected boolean underSurveillance;
    protected int loyalty;
    protected int dangerLevel;
    protected List<String> events;
    protected String location;

    public NPC(String name, int age, String affiliation, String location) {
        super(name, age, affiliation);
        this.location = location;
        this.streetRep = 0;
        this.isHostile = false;
        this.underSurveillance = false;
        this.loyalty = 50;
        this.dangerLevel = 0;
        this.events = new ArrayList<>();
    }

    public int getStreetRep() {
        return streetRep;
    }

    public void gainTrust(int amount) {
        streetRep += amount;
        loyalty += amount / 2;
    }

    public void loseTrust(int amount) {
        streetRep -= amount;
        loyalty -= amount / 2;
        if (streetRep < -50) isHostile = true;
    }

    public void setSurveillance(boolean flag) {
        underSurveillance = flag;
    }

    public boolean isUnderSurveillance() {
        return underSurveillance;
    }

    public void setDangerLevel(int level) {
        dangerLevel = level;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public void addEvent(String event) {
        events.add(event);
    }

    public void triggerEvents() {
        System.out.println(name + "'s Events:");
        for (String event : events) {
            System.out.println("- " + event);
        }
    }

    public String getLocation() {
        return location;
    }

    public abstract void interact();
}