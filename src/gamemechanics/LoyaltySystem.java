public class LoyaltySystem {

    public void evaluateLoyalty(NPC npc) {
        int loyalty = npc.loyalty;

        if (loyalty >= 80) {
            System.out.println(npc.getName() + " is fiercely loyal. They will defend you.");
        } else if (loyalty >= 50) {
            System.out.println(npc.getName() + " is cooperative but cautious.");
        } else if (loyalty >= 30) {
            System.out.println(npc.getName() + " is losing trust.");
        } else {
            System.out.println(npc.getName() + " may flip on you at any time.");
        }
    }

    public boolean willFlip(NPC npc) {
        return npc.loyalty < 25 && npc.streetRep < 0;
    }
}