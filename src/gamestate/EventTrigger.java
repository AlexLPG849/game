public class EventTrigger {
    private Set<String> triggered;

    public EventTrigger() {
        triggered = new HashSet<>();
    }

    public boolean trigger(String eventName) {
        if (triggered.contains(eventName)) {
            return false;
        }
        triggered.add(eventName);
        System.out.println("Event triggered: " + eventName);
        return true;
    }

    public boolean isTriggered(String eventName) {
        return triggered.contains(eventName);
    }
}