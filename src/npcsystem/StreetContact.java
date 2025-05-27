public class StreetContact extends NPC {
    private List<String> rumors;
    private boolean paidOff;
    private int riskToExpose; // 0–100

    public StreetContact(String name, int age, String affiliation, String location) {
        super(name, age, affiliation, location);
        this.rumors = new ArrayList<>();
        this.paidOff = false;
        this.riskToExpose = 30;
    }

    public void addRumor(String rumor) {
        rumors.add(rumor);
    }

    public void bribe(int amount) {
        paidOff = true;
        gainTrust(amount / 10);
        System.out.println(name + " nods: 'You didn't get this from me...'");
    }

    public void spillRumors() {
        System.out.println(name + "'s Rumors:");
        for (String rumor : rumors) {
            System.out.println("- " + rumor);
        }
    }

    public int getExposureRisk() {
        return riskToExpose;
    }

    @Override
    public void interact() {
        if (underSurveillance) {
            System.out.println(name + " whispers: 'Eyes are on me. Lay low.'");
        } else if (paidOff || streetRep >= 40) {
            System.out.println(name + ": 'Got info for you. Don’t ask where it came from.'");
            spillRumors();
        } else {
            System.out.println(name + ": 'Never seen you before. Beat it.'");
        }
    }
}