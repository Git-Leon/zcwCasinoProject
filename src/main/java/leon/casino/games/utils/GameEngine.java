package leon.casino.games.utils;

import leon.casino.games.PlayerInterface;

/**
 * Created by leon on 2/25/18.
 */
public abstract class GameEngine<
        GameTypePlayer extends PlayerInterface,
        GameType extends GameInterface<GameTypePlayer>>
        implements GameEngineInterface<GameTypePlayer, GameType> {

    protected final GameType game;

    public GameEngine(GameType game) {
        this.game = game;
    }

    @Override
    public GameType getGame() {
        return game;
    }

    public final void run() {
        game.run();
        for(GameTypePlayer player : getGame().getPlayers()) {
            evaluateTurn(player);
        }
    }

}
