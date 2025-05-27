public class InventorySystem implements Serializable {
    private Map<Substance, Integer> stock;

    public InventorySystem() {
        stock = new HashMap<>();
    }

    public void add(Substance substance, int quantity) {
        stock.put(substance, stock.getOrDefault(substance, 0) + quantity);
    }

    public boolean remove(Substance substance, int quantity) {
        int available = stock.getOrDefault(substance, 0);
        if (available < quantity) return false;
        stock.put(substance, available - quantity);
        return true;
    }

    public void clear() {
        stock.clear();
        System.out.println("Inventory cleared.");
    }

    public void printStock() {
        System.out.println("Your Inventory:");
        if (stock.isEmpty()) {
            System.out.println("- (empty)");
            return;
        }
        for (Map.Entry<Substance, Integer> entry : stock.entrySet()) {
            System.out.println("- " + entry.getKey().getName() + " x" + entry.getValue());
        }
    }
}