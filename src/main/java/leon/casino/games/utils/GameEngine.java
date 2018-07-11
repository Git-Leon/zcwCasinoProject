package leon.casino.games.utils;

import leon.casino.games.PlayerInterface;
import leon.casino.profile.Profile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 2/25/18.
 */
public abstract class GameEngine<
        GameTypePlayer extends PlayerInterface,
        GameType extends GameInterface<GameTypePlayer>>
        implements GameEngineInterface<GameTypePlayer, GameType> {

    protected final GameType game;
    protected final List<Profile> profileList;

    public GameEngine(GameType game, Profile... profiles) {
        this(game, new ArrayList<>(Arrays.asList(profiles)));
    }

    public GameEngine(GameType game, List<Profile> profiles) {
        this.game = game;
        this.profileList = profiles;
    }

    @Override
    public final GameType getGame() {
        return game;
    }

    protected final List<GameTypePlayer> convertToPlayers(List<Profile> profiles) {
        List<GameTypePlayer> playerList = new ArrayList<>();
        for(Profile profile : profiles) {
            GameTypePlayer player = convertToPlayer(profile);
            playerList.add(player);
        }
        return playerList;
    }

    @Override
    public final void run() {
        game.run();
        for(GameTypePlayer player : getGame().getPlayers()) {
            evaluateTurn(player);
        }
    }

}
