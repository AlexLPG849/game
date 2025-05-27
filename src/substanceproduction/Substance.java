public class Substance {
    private String name;
    private int purity;           // 0–100
    private int marketValue;      // Value per unit
    private int dangerLevel;      // 0–100, affects risk
    private boolean illegal;

    public Substance(String name, int purity, int marketValue, int dangerLevel, boolean illegal) {
        this.name = name;
        this.purity = purity;
        this.marketValue = marketValue;
        this.dangerLevel = dangerLevel;
        this.illegal = illegal;
    }

    public String getName() {
        return name;
    }

    public int getPurity() {
        return purity;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public boolean isIllegal() {
        return illegal;
    }

    public void displayInfo() {
        System.out.println(name + " | Purity: " + purity + "% | Value: $" + marketValue +
                " | Risk: " + dangerLevel + " | Illegal: " + illegal);
    }
}