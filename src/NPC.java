public class NPC {
    private String name;
    private int satisfaction;
    private String preferredSubstance;
    private String currentLocation;
    private int daysSinceLastDeal;

    public NPC(String name, String preferredSubstance, String startLocation) {
        this.name = name;
        this.preferredSubstance = preferredSubstance;
        this.currentLocation = startLocation;
        this.satisfaction = 0;
        this.daysSinceLastDeal = 0;
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
}
