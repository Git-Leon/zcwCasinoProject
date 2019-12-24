package com.github.curriculeon.casino.games.utils;


import com.github.curriculeon.casino.games.cardgames.blackjack.BlackJackGameEngine;
import com.github.curriculeon.casino.games.cardgames.poker.PokerGameEngine;
import com.github.curriculeon.casino.games.mechanicalgames.slots.SlotGameEngine;
import com.github.curriculeon.casino.Decision;

import java.util.function.Supplier;

/**
 * Created by leon on 2/25/18.
 */
public enum GameSelection implements Decision {
    BLACKJACK(BlackJackGameEngine::new),
    POKER(PokerGameEngine::new),
    SLOTS(SlotGameEngine::new);


    private final Supplier<GameEngineInterface> gammeConstructor;

    GameSelection(Supplier<GameEngineInterface> gameConstructor) {
        this.gammeConstructor = gameConstructor;
    }

    public void perform() {
        create().run();
    }

    public GameEngineInterface create() {
        return gammeConstructor.get();
    }
}
