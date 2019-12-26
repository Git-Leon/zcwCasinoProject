package com.github.curriculeon.casino.games.utils;

import com.github.curriculeon.casino.games.PlayerInterface;

/**
 * Created by leon on 2/25/18.
 */
public interface GameInterface<PlayerType extends PlayerInterface> extends Runnable {
    PlayerType[] getPlayers();
    void addPlayer(PlayerType player);
    void removePlayer(PlayerType player);
    Boolean contains(PlayerType player);
    void run();
}
