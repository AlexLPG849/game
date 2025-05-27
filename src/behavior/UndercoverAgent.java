public class UndercoverAgent extends Buyer {
    private List<String> loggedTransactions;
    private boolean exposed;

    public UndercoverAgent(String name) {
        super(name, 60, true);
        this.loggedTransactions = new ArrayList<>();
        this.exposed = false;
    }

    public void logDeal(Substance substance, int quantity) {
        if (!exposed) {
            loggedTransactions.add(quantity + "x " + substance.getName());
        }
    }

    public void expose() {
        exposed = true;
        System.out.println("⚠ " + getName() + " was an undercover agent! All deals are now on record.");
    }

    public void reviewLog() {
        System.out.println("Surveillance Log:");
        for (String log : loggedTransactions) {
            System.out.println("- " + log);
        }
    }

    public boolean isExposed() {
        return exposed;
    }
}