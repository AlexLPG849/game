public class NPCManager {
    private List<NPC> npcList;

    public NPCManager() {
        this.npcList = new ArrayList<>();
    }

    public void addNPC(NPC npc) {
        npcList.add(npc);
    }

    public void interactWithAll() {
        for (NPC npc : npcList) {
            System.out.println("\nInteracting with: " + npc.getName());
            npc.interact();
        }
    }

    public void showAllStatuses() {
        System.out.println("\n=== NPC Statuses ===");
        for (NPC npc : npcList) {
            System.out.println(npc.getName() + " | Affiliation: " + npc.getAffiliation() +
                    " | Rep: " + npc.getStreetRep() + " | Loyalty: " + npc.loyalty +
                    " | Hostile: " + npc.isHostile + " | Surveillance: " + npc.isUnderSurveillance());
        }
    }

    public List<NPC> getNPCs() {
        return npcList;
    }
}