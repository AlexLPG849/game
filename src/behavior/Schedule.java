public class Schedule {
    private Map<Integer, String> timeSlotActivity; // hour -> activity

    public Schedule() {
        timeSlotActivity = new HashMap<>();
    }

    public void setActivity(int hour, String activity) {
        timeSlotActivity.put(hour, activity);
    }

    public String getActivity(int hour) {
        return timeSlotActivity.getOrDefault(hour, "Idle");
    }

    public void displaySchedule() {
        System.out.println("NPC Schedule:");
        for (int hour = 0; hour < 24; hour++) {
            String act = getActivity(hour);
            System.out.printf("%02d:00 - %s\n", hour, act);
        }
    }
}