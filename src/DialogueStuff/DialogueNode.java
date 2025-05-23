package DialogueStuff;
import java.util.List;

public class DialogueNode {
    private String npcText;
    private List<String> playerChoices;
    private List<DialogueNode> nextNodes;
    private boolean isEnding;

    public DialogueNode(String npcText, List<String> playerChoices, List<DialogueNode> nextNodes, boolean isEnding) {
        this.npcText = npcText;
        this.playerChoices = playerChoices;
        this.nextNodes = nextNodes;
        this.isEnding = isEnding;
    }

    public String getNpcText() {
        return npcText;
    }

    public List<String> getPlayerChoices() {
        return playerChoices;
    }

    public List<DialogueNode> getNextNodes() {
        return nextNodes;
    }

    public boolean isEnding() {
        return isEnding;
    }
}


