public class Chemist extends NPC {
    private int skillLevel;
    private int purityBoost;
    private boolean methAddict;
    private int paranoiaLevel;

    public Chemist(String name, int age, String affiliation, String location) {
        super(name, age, affiliation, location);
        this.skillLevel = 70;
        this.purityBoost = 15;
        this.methAddict = false;
        this.paranoiaLevel = 20;
    }

    public int getPurityBoost() {
        return purityBoost + (skillLevel / 10);
    }

    public void increaseParanoia(int amount) {
        paranoiaLevel += amount;
        if (paranoiaLevel > 100) paranoiaLevel = 100;
    }

    @Override
    public void interact() {
        if (paranoiaLevel > 70) {
            System.out.println(name + " twitches: 'They're watching. I know they are.'");
        } else {
            System.out.println(name + ": 'I can cook it better. But don’t mess with me.'");
        }
    }
}
