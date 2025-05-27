public class SurveillanceSystem {

    public void scanNPCs(List<NPC> npcList, int heatLevel) {
        for (NPC npc : npcList) {
            if (npc.isUnderSurveillance()) {
                System.out.println(npc.getName() + " is already under watch.");
            } else if (npc.getDangerLevel() + heatLevel > 100) {
                npc.setSurveillance(true);
                System.out.println(npc.getName() + " is now under surveillance due to suspicion + heat.");
            }
        }
    }

    public void clearSurveillance(List<NPC> npcList) {
        for (NPC npc : npcList) {
            if (npc.isUnderSurveillance()) {
                npc.setSurveillance(false);
                System.out.println("Surveillance cleared from " + npc.getName() + ".");
            }
        }
    }
}