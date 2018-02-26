package leon.casino.games;


import leon.casino.games.cardgames.blackjack.BlackJackGame;
import leon.casino.games.cardgames.poker.PokerGame;
import leon.casino.games.mechanicalgames.slots.SlotGame;

import java.util.function.Supplier;

/**
 * Created by leon on 2/25/18.
 */
public enum GameSelection {
    BLACKJACK(BlackJackGame::new),
    POKER(PokerGame::new),
    SLOTS(SlotGame::new);


    private final Supplier<GameInterface> gammeConstructor;

    GameSelection(Supplier<GameInterface> gameConstructor) {
        this.gammeConstructor = gameConstructor;
    }

    public GameInterface newGame() {
        return gammeConstructor.get();
    }

    public GameInterface create() {
        return createGame(name());
    }

    // for front-facing client
    public static GameInterface createGame(String game) {
        GameSelection gameSelection = null;
        do {
            try {
                gameSelection = GameSelection.valueOf(game.toUpperCase());
                return gameSelection.newGame();
            } catch (IllegalArgumentException iae) {
                continue;
            }
        } while (gameSelection != null);
        return null;
    }
}
