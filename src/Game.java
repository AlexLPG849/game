import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;


public class Game {
    private Map<String, Room> rooms;
    private Player player;
    private CommandParser commandParser;
    private List<NPC> npcs;
    private List<SubstancePlantCode> plants;
    private int turnCount;


    public Game() {
        RoomLoader roomLoader = new RoomLoader();
        rooms = roomLoader.loadRooms("rooms.json");
        player = new Player("entrance");
        commandParser = new CommandParser();
         npcs = new ArrayList<>();
        npcs.add(new NPC("Bob", "Purple Daddy", "")); // add start location
        npcs.add(new NPC("Jesse", "Blue Sky", "")); // add start location

        plants = new ArrayList<>();
        turnCount = 0;

    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Schedule 2! This is a game where you make money! Type 'help' to see all commands.");
        Room currentRoom = rooms.get(player.getCurrentRoomId());
        System.out.println(currentRoom.getLongDescription());
        boolean gameOver = false;
        while (!gameOver) {
            System.out.print("> ");
            String input = scanner.nextLine();
            gameOver = commandParser.parse(input, player, rooms, npcs, plants);

            turnCount++;
                for (SubstancePlantCode plant : plants) {
                    plant.grow();
                }

                for (NPC npc : npcs) {
                    npc.updateSatisfaction(false); 
                }

                for (NPC npc : npcs) {
                    List<String> roomKeys = new ArrayList<>(rooms.keySet());
                    String randomRoomId = roomKeys.get(new Random().nextInt(roomKeys.size()));
                    npc.setCurrentLocation(randomRoomId);
                }

                if (player.getMoney() >= 10000) {
                    System.out.println("You made $10,000 and became the One Who Knocks.");
                    break;
                }
            } 
    }
}