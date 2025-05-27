public class BustRiskCalculator {

    public static boolean isBusted(Buyer buyer, Substance substance, int heatLevel) {
        int baseRisk = substance.getDangerLevel();
        int risk = baseRisk + (buyer.isHighProfile() ? 30 : 0) + heatLevel;

        int roll = (int)(Math.random() * 100);
        boolean busted = roll < risk;

        if (busted) {
            System.out.println("BUST! Deal failed. Law enforcement intervened.");
        } else {
            System.out.println("Deal succeeded safely.");
        }

        return busted;
    }
}