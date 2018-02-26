package leon.casino.games.utils;


import leon.casino.Decision;
import leon.casino.games.cardgames.blackjack.BlackJackGame;
import leon.casino.games.cardgames.poker.PokerGame;
import leon.casino.games.mechanicalgames.slots.SlotGame;

import java.util.function.Supplier;

/**
 * Created by leon on 2/25/18.
 */
public enum GameSelection implements Decision {
    BLACKJACK(BlackJackGame::new),
    POKER(PokerGame::new),
    SLOTS(SlotGame::new);


    private final Supplier<GameInterface> gammeConstructor;

    GameSelection(Supplier<GameInterface> gameConstructor) {
        this.gammeConstructor = gameConstructor;
    }

    public void perform() {
        create().run();
    }

    public GameInterface create() {
        return gammeConstructor.get();
    }
}
