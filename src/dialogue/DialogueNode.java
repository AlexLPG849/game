public class DialogueNode {
    private String prompt;
    private List<String> choices;
    private List<ChoiceResult> results;

    public DialogueNode(String prompt) {
        this.prompt = prompt;
        this.choices = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    public void addChoice(String choice, ChoiceResult result) {
        choices.add(choice);
        results.add(result);
    }

    public void display() {
        System.out.println(prompt);
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ". " + choices.get(i));
        }
    }

    public void select(int index) {
        if (index < 1 || index > results.size()) {
            System.out.println("Invalid choice.");
            return;
        }
        results.get(index - 1).apply();
    }
}