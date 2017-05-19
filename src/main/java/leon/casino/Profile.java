package leon.casino;

public class Profile {
    private final long profileId;
    private final String name;
    private double balance;

    public Profile(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.profileId = Casino.profiles.size();
    }

    public void printInformation() {
        Console.printDashes();

        Console.println("Printing profile details");
        Console.println("\tName:\t\t %s", getName());
        Console.println("\tBalance:\t %s", getBalance());
        Console.println("\tId:\t\t\t %s", getProfileId());
    }

    public void increaseBalance(double amount) {
        double oldBalance = getBalance();
        double newBalance = oldBalance + amount;
        String deltaStr = newBalance > oldBalance ? "increased" : "decreased";

        setBalance(newBalance);
        Console.println("[ %s ]'s balance has %s from [ %s ] to [ %s ]", name, deltaStr, oldBalance, newBalance);
    }

    public void decreaseBalance(double amount) {
        increaseBalance(amount * -1);
    }

    public Double createBetAmount() {
        Console.printDashes();
        double playerBalance = getBalance();
        double playerBet = Console.getLongInput("How much money would you like to bet this game, [ %s ] ?", getName());
        if (playerBet <= playerBalance) {
            return playerBet;
        } else {
            Console.println("You cannot bet more money than what is credited to your player-profile.");
            Console.println("Try inputting a valid less than [ %s ]", playerBalance);
            printInformation();
            return createBetAmount();
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public String getName() {
        return this.name;
    }

    public Long getProfileId() {
        return this.profileId;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }
}
