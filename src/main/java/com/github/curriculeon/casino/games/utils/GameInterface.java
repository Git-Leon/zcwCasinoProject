package com.github.curriculeon.casino.games.utils;

import com.github.curriculeon.casino.games.PlayerInterface;

/**
 * Created by leon on 2/25/18.
 */
public interface GameInterface<T extends PlayerInterface> extends Runnable {
    T[] getPlayers();
    void addPlayer(T player);
    void removePlayer(T player);
    Boolean contains(T player);
    void run();
}
