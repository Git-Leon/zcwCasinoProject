package leon.casino.games.utils;

import leon.casino.games.PlayerInterface;
import leon.casino.profile.Profile;

import java.util.ArrayList;
import java.util.List;

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

    protected List<GameTypePlayer> convertToPlayers(Profile[] profiles) {
        List<GameTypePlayer> playerList = new ArrayList<>();
        for(Profile profile : profiles) {
            GameTypePlayer player = this.convertToPlayer(profile);
            playerList.add(player);
        }
        return playerList;
    }

    protected abstract GameTypePlayer convertToPlayer(Profile profile);

    public final void run() {
        game.run();
        for(GameTypePlayer player : getGame().getPlayers()) {
            evaluateTurn(player);
        }
    }

}
