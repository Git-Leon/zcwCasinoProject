package leon.casino.profile;

import leon.tools.Console;

public class Profile {
    private final Long profileId;
    private final String name;
    private Double balance;

    public Profile(String name, Double balance, Long profileId) {
        this.name = name;
        this.balance = balance;
        this.profileId = profileId;
    }

    public void printInformation() {
        Console.printDashes();

        Console.println("Printing profile details");
        Console.println("\tName:\t\t %s", getName());
        Console.println("\tBalance:\t %s", getBalance());
        Console.println("\tId:\t\t\t %s", getProfileId());
    }


    /**
     *
     * @param amount
     * @return true if the amount is positive
     */
    public boolean increaseBalance(double amount) {
        double oldBalance = getBalance();
        double newBalance = oldBalance + amount;
        setBalance(newBalance);
        return amount > 0;
    }

    public void decreaseBalance(double amount) {
        increaseBalance(-amount);
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
