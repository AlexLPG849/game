public class TransactionLog {
    private List<String> history;

    public TransactionLog() {
        history = new ArrayList<>();
    }

    public void log(String entry) {
        history.add(entry);
    }

    public void printLog() {
        System.out.println("=== Transaction History ===");
        for (String s : history) {
            System.out.println("- " + s);
        }
    }
}