public class DebugConsole {
    private Player player;

    public DebugConsole(Player player) {
        this.player = player;
    }

    public void execute(String cmd) {
        switch (cmd) {
            case "addcash":
                player.addCash(1000);
                break;
            case "clearinv":
                player.getInventory().clear();
                break;
            case "heatup":
                player.adjustHeat(20);
                break;
            default:
                System.out.println("Unknown debug command.");
        }
    }
}