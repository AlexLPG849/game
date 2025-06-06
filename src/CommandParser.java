import java.util.List;
import java.util.Map;
import java.util.Random;

public class CommandParser {
    public boolean parse(String input, Player player, Map<String, Room> rooms, List<NPC> npcs, List<SubstancePlantCode> plants){
        String[] words = input.trim().toLowerCase().split("\\s+");
        if (words.length == 0) {
            System.out.println("Please enter a command.");
            return false;
        }

        String command = words[0];

        switch (command) {
            case "go":
                if (words.length < 2) {
                    System.out.println("Go where?");
                } else {
                    String direction = words[1];
                    Room currentRoom = rooms.get(player.getCurrentRoomId());
                    String nextRoomId = currentRoom.getExits().get(direction);
                    if (nextRoomId != null) {
                        player.setCurrentRoomId(nextRoomId);
                        System.out.println("You move " + direction + ".");
                        currentRoom = rooms.get(player.getCurrentRoomId());
                        System.out.println(currentRoom.getLongDescription());

                    } else {
                        System.out.println("You can't go that way.");
                    }
                }
                return false;
            case "look":
                Room currentRoom = rooms.get(player.getCurrentRoomId());
                System.out.println(currentRoom.getLongDescription());

                if (words.length > 1) {
                    String itemName = words[1];
                    boolean itemFound = false;
                        for (Item item : currentRoom.getItems()) {
                            if (item.getName().equalsIgnoreCase(itemName)) {
                                itemFound = true;
                                    System.out.println("You see: " + item.getDescription());
                    break;
            }
        }
                    if (!itemFound) {
                        System.out.println("There is no " + itemName + " here.");
        }
    }
    return false;

            case "inventory":
                if (player.getInventory().isEmpty()) {
                    System.out.println("Your inventory is empty.");
                } else {
                    System.out.println("You are carrying:");
                    for (Item item : player.getInventory()) {
                    System.out.println("- " + item.getName() + ": " + item.getDescription());
                }
            }
    return false;

            case "take":
                if (words.length < 2) {
                    System.out.println("Take what?");
                } else {
                    String itemName = words[1];
                    Room room = rooms.get(player.getCurrentRoomId());
                    Item itemToTake = null;
                    for (Item item : room.getItems()) {
                        if (item.getName().equalsIgnoreCase(itemName)) {
                            itemToTake = item;
                            break;
                        }
                    }
                    if (itemToTake != null) {
                        room.removeItem(itemToTake);
                        player.addItem(itemToTake);
                        System.out.println("You take the " + itemToTake.getName() + ".");
                    } else {
                        System.out.println("There is no " + itemName + " here.");
                    }
                }
                return false;
            case "drop":
                if (words.length < 2) {
                    System.out.println("Drop what?");
                } else {
                    String itemName = words[1];
                    Item itemToDrop = null;
                    for (Item item : player.getInventory()) {
                        if (item.getName().equalsIgnoreCase(itemName)) {
                            itemToDrop = item;
                            break;
                        }
                    }
                    if (itemToDrop != null) {
                        player.removeItem(itemToDrop);
                        Room room = rooms.get(player.getCurrentRoomId());
                        room.addItem(itemToDrop);
                        System.out.println("You drop the " + itemToDrop.getName() + ".");
                    } else {
                        System.out.println("You don't have a " + itemName + ".");
                    }
                }
                return false;
                case "deal":
                    Room room = rooms.get(player.getCurrentRoomId());
                    List<NPC> presentNpcs = room.getNpcs();

                    if (presentNpcs.isEmpty()) {
                        System.out.println("There's no one here to deal to.");
                            return false;
                    }

                    boolean dealt = false;
                        for (NPC npc : presentNpcs) {
                            for (Item item : player.getInventory()) {
                                if (item.getName().equalsIgnoreCase(npc.getPreferredSubstance())) {
                                    int payout = 100 + new Random().nextInt(npc.getSatisfaction() + 150);
                                    player.addMoney(payout);
                                    player.removeItem(item);
                                    npc.updateSatisfaction(true);
                                    System.out.println(npc.getName() + " buys " + item.getName() + " for $" + payout + ".");
                                    dealt = true;
                    break;
                            }
                        }
                    }

                    if (!dealt) {
                        System.out.println("You have nothing these people want.");
                        for (NPC npc : presentNpcs) {
                            npc.updateSatisfaction(false);
                            }
                    }

    return false;

            case "help":
                System.out.println("Available commands:");
                System.out.println("- go [direction]: Move to a different room (e.g., go north).");
                System.out.println("- look: Look around the room.");
                System.out.println("- look [item]: Look at a specific item in the room.");
                System.out.println("- take [item]: Pick up an item.");
                System.out.println("- drop [item]: Drop an item from your inventory.");
                System.out.println("- inventory: Show what you're carrying.");
                System.out.println("- money: Show how much money you have.");
                System.out.println("- deal: Attempt to deal drugs to any NPCs in the room.");
                System.out.println("- plant [type]: Plant a substance to grow (at home only).");
                System.out.println("- harvest: Harvest grown substances if they're ready.");
                System.out.println("- phone: Check where dealable NPCs are and their mood.");
                System.out.println("- help: Show this help menu.");
                System.out.println("- quit: Exit the game.");
                return false;

            case "money":
                System.out.println("You have $" + player.getMoney());
                return false;
            case "quit":
                System.out.println("Yeah yeah, later man.");
                return true;
            default:
                System.out.println("Explain it again. I don't follow.");
                return false;
        }
    }
}
