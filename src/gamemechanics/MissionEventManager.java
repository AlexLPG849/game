public class MissionEventManager {
    private List<String> activeMissions;
    private List<String> completedMissions;

    public MissionEventManager() {
        this.activeMissions = new ArrayList<>();
        this.completedMissions = new ArrayList<>();
    }

    public void triggerMission(String missionName) {
        if (!activeMissions.contains(missionName)) {
            activeMissions.add(missionName);
            System.out.println("Mission started: " + missionName);
        }
    }

    public void completeMission(String missionName) {
        if (activeMissions.remove(missionName)) {
            completedMissions.add(missionName);
            System.out.println("Mission completed: " + missionName);
        }
    }

    public boolean isMissionActive(String name) {
        return activeMissions.contains(name);
    }

    public boolean isMissionCompleted(String name) {
        return completedMissions.contains(name);
    }

    public void listMissions() {
        System.out.println("Active Missions:");
        for (String m : activeMissions) System.out.println("- " + m);
        System.out.println("Completed Missions:");
        for (String m : completedMissions) System.out.println("- " + m);
    }
}