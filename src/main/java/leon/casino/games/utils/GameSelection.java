package leon.casino.games.utils;


import leon.casino.Decision;
import leon.casino.games.cardgames.blackjack.BlackJackGameEngine;
import leon.casino.games.cardgames.poker.PokerGameEngine;
import leon.casino.games.mechanicalgames.slots.SlotGameEngine;

import java.util.function.Supplier;

/**
 * Created by leon on 2/25/18.
 */
public enum GameSelection implements Decision {
    BLACKJACK(BlackJackGameEngine::new),
    POKER(PokerGameEngine::new),
    SLOTS(SlotGameEngine::new);


    private final Supplier<GameEngineInterface> gameConstructor;

    GameSelection(Supplier<GameEngineInterface> gameConstructor) {
        this.gameConstructor = gameConstructor;
    }

    public void perform() {
        create().run();
    }

    public GameEngineInterface create() {
        return gameConstructor.get();
    }
}
