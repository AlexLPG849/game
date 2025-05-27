public class GameEngine {
    private Player player;
    private TransactionLog log;

    public GameEngine(Player player) {
        this.player = player;
        this.log = new TransactionLog();
    }

    public void produceAndStore(LabWorker worker, Recipe recipe, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Substance s = worker.craft(recipe);
            if (s != null) {
                player.getInventory().add(s, 1);
                log.log("Produced: " + s.getName() + " at " + s.getPurity() + "%");
            }
        }
    }

    public void attemptDeal(Substance s, Buyer buyer, int quantity) {
        InventorySystem inventory = player.getInventory();
        if (!inventory.remove(s, quantity)) {
            System.out.println("Not enough product to sell.");
            return;
        }

        DealHandler.attemptSale(s, quantity, buyer.getTrustLevel());

        boolean busted = BustRiskCalculator.isBusted(buyer, s, player.getHeat());
        if (busted) {
            player.adjustHeat(20);
            player.adjustReputation("DEA", 10);
        } else {
            int income = s.getMarketValue() * quantity;
            player.addCash(income);
            player.adjustHeat(s.getDangerLevel() / 4);
            buyer.changeTrust(5);
            player.adjustReputation("Cartel", 5);
        }

        log.log("Deal attempt with " + buyer.getName() + ": " + quantity + "x " + s.getName() + (busted ? " [BUSTED]" : " [CLEAN]"));
    }

    public void showGameState() {
        System.out.println("===== " + player.getName() + "'s Status =====");
        System.out.println("Cash: $" + player.getCash());
        System.out.println("Heat: " + player.getHeat() + "/100");
        player.getInventory().printStock();
    }

    public void showLog() {
        log.printLog();
    }
}