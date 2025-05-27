public class CartelMember extends NPC {
    private int rank; // 1 = low-level, 5 = boss
    private List<NPC> subordinates;

    public CartelMember(String name, int age, String affiliation, String location, int rank) {
        super(name, age, affiliation, location);
        this.rank = rank;
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(NPC npc) {
        subordinates.add(npc);
    }

    public void issueOrder(String order) {
        System.out.println(name + " (Rank " + rank + ") issues an order: " + order);
    }

    public int getRank() {
        return rank;
    }

    @Override
    public void interact() {
        if (isHostile) {
            System.out.println(name + ": 'We don’t forgive. You crossed the line.'");
        } else if (streetRep >= 70 && rank >= 3) {
            System.out.println(name + ": 'You're proving yourself. Let's talk business.'");
        } else {
            System.out.println(name + ": 'You don’t have clearance for this conversation.'");
        }
    }
}