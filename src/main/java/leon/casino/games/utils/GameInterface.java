package leon.casino.games.utils;

import leon.casino.games.PlayerInterface;

import java.util.List;

/**
 * Created by leon on 2/25/18.
 */
public interface GameInterface<T extends PlayerInterface> extends Runnable {
    List<T> getPlayers();
    void addPlayer(T player);
    void removePlayer(T player);
    Boolean contains(T player);
    void run();
}
