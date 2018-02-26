package leon.casino.games.utils;

import leon.casino.games.PlayerInterface;

/**
 * Created by leon on 2/25/18.
 */
public abstract class GameEngine<
        GameType extends GameInterface,
        GameTypePlayer extends PlayerInterface>
        implements GameEngineInterface<GameType, GameTypePlayer> {

    private final GameType game;

    public GameEngine(GameType game) {
        this.game = game;
    }

    @Override
    public GameType getGame() {
        return game;
    }

}
