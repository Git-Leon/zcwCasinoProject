package leon.casino.games.utils;

import leon.casino.games.PlayerInterface;

/**
 * Created by leon on 2/25/18.
 */
public interface GameEngineInterface<
        GameType extends GameInterface,
        GameTypePlayer extends PlayerInterface>
        extends Runnable {

    GameType getGame();
    void evaluateTurn(GameTypePlayer player);
    void run();
}
