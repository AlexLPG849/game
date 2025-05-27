public class GameLoop {
    private Player player;
    private GameEngine engine;
    private MissionBoard board;
    private Police police;

    public GameLoop(Player player) {
        this.player = player;
        this.engine = new GameEngine(player);
        this.board = new MissionBoard();
        this.police = new Police();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("=== Welcome to the Game ===");

        while (true) {
            System.out.println("\n1. Show Status\n2. Show Missions\n3. Police Check\n4. Exit");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    engine.showGameState();
                    break;
                case "2":
                    board.showMissions();
                    break;
                case "3":
                    police.checkForBust(player);
                    break;
                case "4":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }
}