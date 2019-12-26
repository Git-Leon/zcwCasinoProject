package com.github.curriculeon.casino.games.cardgames.blackjack;

import com.github.curriculeon.casino.games.cardgames.blackjack.player.BlackJackPlayer;
import com.github.curriculeon.casino.games.cardgames.blackjack.player.BlackJackPlayerState;
import com.github.curriculeon.casino.games.utils.GameEngine;
import com.github.curriculeon.tools.Console;

/**
 * Created by leon on 2/25/18.
 */
public class BlackJackGameEngine extends GameEngine<BlackJackPlayer, BlackJackGame> {
    public BlackJackGameEngine() {
        super(new BlackJackGame());
    }

    @Override
    public void evaluateTurn(BlackJackPlayer player) {
        do {
            BlackJackPlayerState playerState = BlackJackPlayerState.getState(player);

            BlackJackGameEngineDecision gameDecision = BlackJackGameEngineDecision.getDecision(playerState);
            gameDecision.perform(this.getGame(), player);
            Console.println(gameDecision.name() + "!");
        } while (player.getState().equals(BlackJackGameEngineDecision.UNDER));
    }

    @Override
    public void run() {
        for(BlackJackPlayer player : getGame().getPlayers()) {
            evaluateTurn(player);
        }
    }
}
