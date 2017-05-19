package leon.casino;

import leon.tools.Console;

/**
 * Created by leon on 5/17/17.
 */
public class BetCreator {

    public static Double createBetAmount(Profile profile) {
        Console.printDashes();
        double playerBalance = profile.getBalance();
        double playerBet = Console.getLongInput("How much money would you like to bet this game, [ %s ] ?", profile.getName());
        if (playerBet <= playerBalance) {
            return playerBet;
        } else {
            Console.println("You cannot bet more money than what is credited to your player-profile.");
            Console.println("Try inputting a valid less than [ %s ]", playerBalance);
            profile.printInformation();
            return createBetAmount(profile);
        }
    }
}
