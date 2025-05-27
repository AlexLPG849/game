public class LawEnforcement extends NPC {
    private boolean undercover;
    private int suspicionMeter;
    private int investigationLevel;

    public LawEnforcement(String name, int age, String affiliation, String location, boolean undercover) {
        super(name, age, affiliation, location);
        this.undercover = undercover;
        this.suspicionMeter = 0;
        this.investigationLevel = 0;
    }

    public void investigate(String subject) {
        System.out.println(name + " is investigating: " + subject);
        investigationLevel += 10;
        suspicionMeter += 15;
    }

    public boolean isUndercover() {
        return undercover;
    }

    public int getSuspicionMeter() {
        return suspicionMeter;
    }

    @Override
    public void interact() {
        if (undercover) {
            System.out.println(name + ": 'I’m just another street guy... trust me.'");
        } else {
            System.out.println(name + ": 'You're being watched. Tread carefully.'");
        }
    }
}