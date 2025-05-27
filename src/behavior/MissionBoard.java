public class MissionBoard {
    private List<String> availableMissions;

    public MissionBoard() {
        this.availableMissions = new ArrayList<>();
        availableMissions.add("Deliver 5 units of high-purity product.");
        availableMissions.add("Sell to 3 different buyers.");
        availableMissions.add("Reach 75 rep with Cartel.");
    }

    public void showMissions() {
        System.out.println("=== Active Missions ===");
        for (int i = 0; i < availableMissions.size(); i++) {
            System.out.println((i + 1) + ". " + availableMissions.get(i));
        }
    }

    public void completeMission(int index) {
        if (index < 1 || index > availableMissions.size()) {
            System.out.println("Invalid mission.");
            return;
        }
        System.out.println("Mission complete: " + availableMissions.get(index - 1));
        availableMissions.remove(index - 1);
    }
}