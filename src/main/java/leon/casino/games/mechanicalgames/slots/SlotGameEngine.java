package leon.casino.games.mechanicalgames.slots;

import leon.casino.games.utils.GameEngine;
import leon.casino.profile.Profile;
import leon.tools.Console;

import java.util.List;

/**
 * Created by danielprahl on 5/9/17.
 */
public class SlotGameEngine extends GameEngine<SlotPlayer, SlotGame> {

    public SlotGameEngine(List<Profile> profileList) {
        super(new SlotGame(profileList));
    }

    @Override
    public void evaluateTurn(SlotPlayer player) {
        // Player bets
        // Player spins
        // Depending on outcome of spin, player gets payout or loses bet amount
        // Repeat until rich or poor
        getGame().addPlayer(player);
        Profile playerProfile = player.getProfile();



        String response = null;
        do {
            String playerName = playerProfile.getName();
            double playerBalance = playerProfile.getBalance();
            int playerBet = playerProfile.createBetAmount().intValue();


            Console.printDashes();
            Console.println("Hey, [ %s ]!", playerName.toUpperCase());
            Console.println("Your current balance is [ %s ]", playerBalance);
            Console.println("You have currently bet an amount of [ %s ].", playerBet);


            response = getResponse(response);
            handleResponse(player, response);
        }
        while (!response.equalsIgnoreCase("quit"));
    }

    // TODO - fix trash
    private void handleResponse(SlotPlayer player, String response) {
        switch (response.toLowerCase()) {
            case "quit":
                break;

            case "pull lever":
                player.pullLever(getGame());
                break;

            default:
                Console.println("Invalid command.");
        }
    }


    // TODO - fix trash
    private String getResponse(String response) {
        while (true) {
            Console.printDashes();
            Console.println("Select one of the following options.");
            response = Console.getStringInput("[quit], [pull lever]");
            return response;
        }
    }

    @Override
    public SlotPlayer convertToPlayer(Profile profile) {
        return new SlotPlayer(profile);
    }
}