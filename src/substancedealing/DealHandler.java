public class DealHandler {

    public static void attemptSale(Substance substance, int quantity, int buyerTrust) {
        int risk = substance.getDangerLevel();
        int trustRequired = risk / 2;

        if (buyerTrust < trustRequired) {
            System.out.println("Buyer refuses: not enough trust to handle " + substance.getName() + ".");
            return;
        }

        int total = substance.getMarketValue() * quantity;
        System.out.println("Sold " + quantity + " units of " + substance.getName() + " for $" + total + ".");
    }
}