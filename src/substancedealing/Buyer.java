public class Buyer {
    private String name;
    private int trustLevel; // 0–100
    private boolean highProfile;

    public Buyer(String name, int trustLevel, boolean highProfile) {
        this.name = name;
        this.trustLevel = trustLevel;
        this.highProfile = highProfile;
    }

    public String getName() {
        return name;
    }

    public int getTrustLevel() {
        return trustLevel;
    }

    public void changeTrust(int amount) {
        trustLevel += amount;
        if (trustLevel > 100) trustLevel = 100;
        if (trustLevel < 0) trustLevel = 0;
    }

    public boolean isHighProfile() {
        return highProfile;
    }
}