public class Police {
    public void checkForBust(Player player) {
        int heat = player.getHeat();
        if (heat >= 80) {
            System.out.println("⚠ RAID: Police bust your stash. You lose product and $2000.");
            player.getInventory().clear(); // Add clear() to InventorySystem
            player.spendCash(2000);
            player.adjustHeat(-50);
        } else if (heat >= 60) {
            System.out.println("🚨 Police are watching. Laying low is advised.");
        } else {
            System.out.println("Police activity is low.");
        }
    }
}