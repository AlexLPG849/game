public class Dealer extends NPC {
    private List<String> productList;
    private int markupPercent;
    private int reliability;

    public Dealer(String name, int age, String affiliation, String location) {
        super(name, age, affiliation, location);
        this.productList = new ArrayList<>();
        this.markupPercent = 30; // default markup
        this.reliability = 70;   // 0–100 scale
    }

    public void addProduct(String product) {
        productList.add(product);
    }

    public void showProducts() {
        System.out.println(name + "'s Product List:");
        for (String product : productList) {
            System.out.println("- " + product + " (+" + markupPercent + "% markup)");
        }
    }

    public void setMarkupPercent(int percent) {
        markupPercent = percent;
    }

    public int getReliability() {
        return reliability;
    }

    public void adjustReliability(int amount) {
        reliability += amount;
        if (reliability > 100) reliability = 100;
        if (reliability < 0) reliability = 0;
    }

    @Override
    public void interact() {
        if (isHostile) {
            System.out.println(name + " snarls: 'I don’t deal with rats.'");
        } else if (streetRep >= 50) {
            System.out.println(name + " says: 'You want quality, I got you. Trust premium only.'");
            showProducts();
        } else {
            System.out.println(name + " says: 'Not sure I should sell to you yet.'");
        }
    }
}