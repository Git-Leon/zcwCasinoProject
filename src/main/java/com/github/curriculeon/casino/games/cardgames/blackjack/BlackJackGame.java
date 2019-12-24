package com.github.curriculeon.casino.games.cardgames.blackjack;

import com.github.curriculeon.casino.games.cardgames.blackjack.player.BlackJackPlayer;
import com.github.curriculeon.casino.games.utils.Game;
import com.github.curriculeon.casino.profile.ProfileInterface;
import com.github.curriculeon.casino.profile.ProfileManager;
import com.github.curriculeon.tools.Console;

import java.util.Arrays;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class BlackJackGame extends Game<BlackJackPlayer> {
    private BlackJackDealer dealer;

    public BlackJackGame() {
        Console.println("Beginning a game of blackjack...");
        this.players = Arrays.asList(createPlayers());
        this.dealer = new BlackJackDealer();

        dealer.deal(players, 2);
    }

    @Override
    public BlackJackPlayer[] getPlayers() {
        return players.stream().toArray(BlackJackPlayer[]::new);
    }


    @Override
    public void addPlayer(BlackJackPlayer player) {
        players.add(player);
    }

    @Override
    public void removePlayer(BlackJackPlayer player) {
        players.remove(player);
    }

    @Override
    public Boolean contains(BlackJackPlayer player) {
        return players.contains(player);
    }

    @Override
    public void run() {

    }

    public void printTable() {
        for (BlackJackPlayer player : players) {
            player.printHand();
        }
        dealer.printHand();
    }

    private BlackJackPlayer[] createPlayers() {
        int numberOfPlayers = Console.getIntegerInput("How many players will be playing?");
        ProfileInterface[] profiles = ProfileManager.DEPRECATED_INSTANCE.getProfiles(numberOfPlayers);
        BlackJackPlayer[] blackJackPlayers = new BlackJackPlayer[numberOfPlayers];

        // create profiles
        for (int i = 0; i < blackJackPlayers.length; i++) {
            ProfileInterface profile = profiles[i];
            double betAmount = profile.createBetAmount();
            BlackJackPlayer player = new BlackJackPlayer(profile, betAmount);
            blackJackPlayers[i] = player;
        }
        return blackJackPlayers;
    }


    public BlackJackDealer getDealer() {
        return dealer;
    }
}
