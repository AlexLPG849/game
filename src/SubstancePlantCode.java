public class SubstancePlantCode {
    private String type;
    private int growTime;
    private int turnsGrown;

    public SubstancePlantCode(String type, int growTime) {
        this.type = type;
        this.growTime = growTime;
        this.turnsGrown = 0;
    }

    public void grow() {
        turnsGrown++;
    }

    public boolean isReadyToHarvest() {
        return turnsGrown >= growTime;
    }

    public Item harvest() {
        if (isReadyToHarvest()) {
            return new Item(type.toLowerCase(), type, "Freshly harvested " + type);
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public int getTurnsGrown() {
        return turnsGrown;
    }

    public int getGrowTime() {
        return growTime;
    }
}