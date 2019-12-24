package com.github.curriculeon.casino.games.cardgames.blackjack.player;

import com.github.curriculeon.casino.games.cardgames.blackjack.BlackJackGame;
import com.github.curriculeon.casino.games.cardgames.blackjack.BlackJackGameDecision;

import java.util.function.BiConsumer;

/**
 * Created by leon on 2/25/18.
 */
public enum BlackJackPlayerDecision implements BlackJackGameDecision {
    HIT((game, player) -> {
        game.getDealer().deal(player, 1);
    }),

    STAND((game, player) -> {
        player.setState(BlackJackPlayerState.STAND);
    }),


    HAND((game, player) -> {
        player.printHand();
    }),

    TABLE((game, player) -> {
        game.printTable();
    });


    private final BiConsumer<BlackJackGame, BlackJackPlayer> operation;

    BlackJackPlayerDecision(BiConsumer<BlackJackGame, BlackJackPlayer> operation) {
        this.operation = operation;
    }

    public void perform(BlackJackGame game, BlackJackPlayer player) {
        operation.accept(game, player);
    }
}
