public class MarketSimulator {

    public static int getAdjustedPrice(Substance s, int demandFactor) {
        int base = s.getMarketValue();
        int adjusted = base + (demandFactor * 5) + (s.getPurity() / 10);
        return adjusted;
    }

    public static void simulatePriceFluctuation(Substance s) {
        int volatility = (int)(Math.random() * 10) - 5;
        int newValue = s.getMarketValue() + volatility;
        System.out.println("Market shift: " + s.getName() + " price changed by $" + volatility + " to $" + newValue);
    }
}