package DialogueStuff;
import java.util.List;
import java.util.Scanner;

public class DialogueSystem {
    private DialogueNode currentNode;
    private Scanner scanner;

    public DialogueSystem(DialogueNode startingNode) {
        this.currentNode = startingNode;
        this.scanner = new Scanner(System.in);
    }

    public void startDialogue() {
        while (!currentNode.isEnding()) {
            System.out.println("NPC: " + currentNode.getNpcText());
            List<String> choices = currentNode.getPlayerChoices();
            for (int i = 0; i < choices.size(); i++) {
                System.out.println((i + 1) + ": " + choices.get(i));
            }

            int choice = getPlayerChoice(choices.size());
            currentNode = currentNode.getNextNodes().get(choice - 1);
        }

        // Ending line
        System.out.println("NPC: " + currentNode.getNpcText());
        System.out.println("The End.");
    }

    private int getPlayerChoice(int maxChoice) {
        int choice = 0;
        while (choice < 1 || choice > maxChoice) {
            System.out.print("Choose an option (1-" + maxChoice + "): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Just loop again
            }
        }
        return choice;
    }
}
