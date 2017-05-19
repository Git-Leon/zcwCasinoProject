package leon.casino.mechanicalgames.slots;

import leon.casino.Console;
import leon.casino.Profile;
import leon.casino.ProfileManager;

/**
 * Created by jarrydstamatelos on 5/9/17.
 */
public class SlotGame {


    public void play() {
        Profile profile = ProfileManager.selectProfile();
        SlotPlayer player = new SlotPlayer(profile);
        play(player);
    }


    public void play(SlotPlayer player) {
        Profile playerProfile = player.getProfile();
        SlotMachine slotMachine = new SlotMachine(player);
        String response;
        do {
            String playerName = playerProfile.getName();
            double playerBalance = playerProfile.getBalance();
            int playerBet = playerProfile.createBetAmount().intValue();


            Console.printDashes();
            Console.println("Hey, [ %s ]!", playerName.toUpperCase());
            Console.println("Your current balance is [ %s ]", playerBalance);
            Console.println("You have currently bet an amount of [ %s ].", playerBet);

            handle_response:
            while (true) {
                Console.printDashes();
                Console.println("Select one of the following options.");
                response = Console.getStringInput("[quit], [pull lever]");
                switch (response.toLowerCase()) {
                    case "quit":
                        break;

                    case "pull lever":
                        player.pullLever(slotMachine);
                        break;

                    default:
                        Console.println("Invalid command.");
                        continue handle_response;
                }
            }
        }
        while (!response.equalsIgnoreCase("quit"));
    }


    // Player bets
    // Player spins
    // Depending on outcome of spin, player gets payout or loses bet amount
    // Repeat until rich or poor

}
