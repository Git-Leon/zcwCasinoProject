package com.github.curriculeon.casino.games.mechanicalgames.slots;

import com.github.curriculeon.casino.games.utils.GameEngine;
import com.github.curriculeon.casino.profile.ProfileInterface;
import com.github.curriculeon.tools.Console;

/**
 * Created by danielprahl on 5/9/17.
 */
public class SlotGameEngine extends GameEngine<SlotPlayer, SlotGame> {

    public SlotGameEngine() {
        super(new SlotGame());
    }


    @Override
    public void run() {

    }

    @Override
    public void evaluateTurn(SlotPlayer player) {
        // Player bets
        // Player spins
        // Depending on outcome of spin, player gets payout or loses bet amount
        // Repeat until rich or poor
        getGame().addPlayer(player);
        ProfileInterface playerProfile = player.getProfile();



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
}