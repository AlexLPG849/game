public class ChoiceResult {
    private int trustChange;
    private int heatChange;
    private int moralityChange;
    private String message;

    public ChoiceResult(int trustChange, int heatChange, int moralityChange, String message) {
        this.trustChange = trustChange;
        this.heatChange = heatChange;
        this.moralityChange = moralityChange;
        this.message = message;
    }

    public void apply() {
        System.out.println("Choice Result: " + message);
        // These should hook into actual systems
        System.out.println("Effects → Trust: " + trustChange + ", Heat: " + heatChange + ", Morality: " + moralityChange);
    }
}