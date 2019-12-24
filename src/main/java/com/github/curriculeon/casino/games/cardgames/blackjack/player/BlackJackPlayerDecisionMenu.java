package com.github.curriculeon.casino.games.cardgames.blackjack.player;

import com.github.curriculeon.casino.AbstractDecisionMenu;
import com.github.curriculeon.casino.games.cardgames.blackjack.BlackJackGame;
import com.github.curriculeon.casino.profile.ProfileInterface;
import com.github.curriculeon.tools.StringAssembler;

/**
 * Created by leon on 2/25/18.
 */
public class BlackJackPlayerDecisionMenu extends AbstractDecisionMenu<BlackJackPlayerDecision> {
    private final BlackJackPlayer player;
    private final BlackJackGame game;

    public BlackJackPlayerDecisionMenu(BlackJackGame game, BlackJackPlayer player) {
        super(BlackJackPlayerDecision.values());
        this.player = player;
        this.game = game;
    }

    @Override
    public String toString() {
        // profile
        ProfileInterface playerProfile = player.getProfile();
        String playerName = playerProfile.getName();

        // gambling
        double playerBalance = playerProfile.getBalance();
        int playerBet = player.getBetAmount().intValue();

        // card player
        int playerHandTotal = player.getHandTotal();
        int dealerHandTotal = game.getDealer().getHandTotal();

        // black jack card player
        BlackJackPlayerState playerState = BlackJackPlayerState.getState(player);

        return new StringAssembler("\n")
                .append("Welcome to the BlackJack Player-Decision Menu, [ %s ]!", playerName.toUpperCase())
                .append("Your current balance is [ %s ]", playerBalance)
                .append("Your current hand-total is [ %s ]", playerHandTotal)
                .append("You have currently bet an amount of [ %s ].", playerBet)
                .append("Your current run-state is [ %s ].", playerState.name())
                .append("What action would you like to take?")
                .toString();
    }
}
