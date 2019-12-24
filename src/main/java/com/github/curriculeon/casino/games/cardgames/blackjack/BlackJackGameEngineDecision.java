package com.github.curriculeon.casino.games.cardgames.blackjack;

import com.github.curriculeon.casino.games.cardgames.blackjack.player.BlackJackPlayer;
import com.github.curriculeon.casino.games.cardgames.blackjack.player.BlackJackPlayerDecisionMenu;
import com.github.curriculeon.casino.games.cardgames.blackjack.player.BlackJackPlayerState;
import com.github.curriculeon.casino.profile.ProfileInterface;

import java.util.function.BiConsumer;

/**
 * Created by leon on 2/25/18.
 */
public enum BlackJackGameEngineDecision implements BlackJackGameDecision {

    BLACKJACK((game, player) -> {
        player.getProfile().increaseBalance(player.getBetAmount());
        player.setState(BlackJackPlayerState.BLACKJACK);
    }),

    BUST((game, player) -> {
        player.getProfile().decreaseBalance(player.getBetAmount());
        player.setState(BlackJackPlayerState.BUST);
    }),


    UNDER((game, player) -> {
        BlackJackPlayerDecisionMenu blackJackPlayerDecisionMenu = new BlackJackPlayerDecisionMenu(game, player);
        blackJackPlayerDecisionMenu.getInput();
    }),


    STAND((game, player) -> {
        ProfileInterface playerProfile = player.getProfile();
        double playerBet = player.getBetAmount();
        int playerHandTotal = player.getHandTotal();
        int dealerHandTotal = game.getDealer().getHandTotal();
        int rewardMultiplier = playerHandTotal > dealerHandTotal ? 1 : -1;

        playerProfile.increaseBalance(rewardMultiplier * playerBet);
    });



    private final BiConsumer<BlackJackGame, BlackJackPlayer> operation;

    BlackJackGameEngineDecision(BiConsumer<BlackJackGame, BlackJackPlayer> operation) {
        this.operation = operation;
    }

    public void perform(BlackJackGame game, BlackJackPlayer player) {
        operation.accept(game, player);
        player.setState(getPlayerState());
    }

    public BlackJackPlayerState getPlayerState() {
        return BlackJackPlayerState.valueOf(this.name());
    }

    public static BlackJackGameEngineDecision getDecision(BlackJackPlayerState playerState) {
        return BlackJackGameEngineDecision.valueOf(playerState.name());
    }
}
