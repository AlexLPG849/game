public class Territory {
    private String name;
    private int controlLevel; // 0–100
    private boolean contested;

    public Territory(String name) {
        this.name = name;
        this.controlLevel = 50;
        this.contested = false;
    }

    public void adjustControl(int delta) {
        controlLevel += delta;
        if (controlLevel < 0) controlLevel = 0;
        if (controlLevel > 100) controlLevel = 100;
        contested = (controlLevel > 40 && controlLevel < 60);
    }

    public void displayStatus() {
        System.out.println("Territory: " + name + " | Control: " + controlLevel + "% | Contested: " + contested);
    }
}