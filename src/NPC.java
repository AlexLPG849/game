import DialogueStuff.DialogueNode;

    public class NPC {
        private String name;
        private int satisfaction;
        private String preferredSubstance;
        private String currentLocation;
        private int daysSinceLastDeal;
        private String startingNode;
        private DialogueNode dialogueNode;

    public NPC(String npcName, String preferredSubstance, String startLocation, String startingNode) {
        this.name = npcName;
        this.preferredSubstance = preferredSubstance;
        this.currentLocation = startLocation;
        this.startingNode = startingNode;
        this.satisfaction = 0;
        this.daysSinceLastDeal = 0;
    }

    public NPC(String npcName, DialogueNode startingNode) {
        this.name = npcName;
        this.dialogueNode = startingNode;
        this.satisfaction = 0;
        this.daysSinceLastDeal = 0;
        this.preferredSubstance = "";
        this.currentLocation = "";
        this.startingNode = "";
    }

    public void updateSatisfaction(boolean dealtToday) {
        if (dealtToday) {
            satisfaction = Math.min(100, satisfaction + 20);
            daysSinceLastDeal = 0;
        } else {
            daysSinceLastDeal++;
            satisfaction = Math.max(-100, satisfaction - 10 * daysSinceLastDeal);
        }
    }

    public String getGreeting() {
        if (satisfaction >= 50) return "Hey, good to see you!";
        if (satisfaction >= 0) return "Yo.";
        return "Where the hell have you been?";
    }

    public String getName() {
        return name;
    }

    public String getPreferredSubstance() {
        return preferredSubstance;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String loc) {
        currentLocation = loc;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public DialogueNode getDialogueNode() {
        return dialogueNode;
    }

    public String getStartingNode(){
        return startingNode;
    }
}
