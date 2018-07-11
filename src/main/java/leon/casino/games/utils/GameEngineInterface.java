package leon.casino.games.utils;

import leon.casino.games.PlayerInterface;
import leon.casino.profile.Profile;

/**
 * Created by leon on 2/25/18.
 */
public interface GameEngineInterface<
        GameTypePlayer extends PlayerInterface,
        GameType extends GameInterface<GameTypePlayer>>
        extends Runnable {

    GameTypePlayer convertToPlayer(Profile profile);
    GameType getGame();
    void evaluateTurn(GameTypePlayer player);
    void run();
}
