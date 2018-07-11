package leon.casino.games.utils;

import leon.casino.games.PlayerInterface;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayer;
import leon.casino.profile.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 2/25/18.
 */
abstract public class Game<PlayerType extends PlayerInterface>
        implements GameInterface<PlayerType> {
    protected final List<PlayerType> playerList;

    public Game() {
        this.playerList = new ArrayList<>();
    }

    @Override
    public final List<PlayerType> getPlayers() {
        return playerList;
    }

    @Override
    public final void addPlayer(PlayerType player) {
        if (!contains(player)) {
            playerList.add(player);
        }
    }

    @Override
    public final void removePlayer(PlayerType player) {
        playerList.add(player);
    }

    @Override
    public final  Boolean contains(PlayerType player) {
        return playerList.contains(player);
    }

    public final void addPlayers(List<PlayerType> players) {
        players.forEach(this::addPlayer);
    }
}
