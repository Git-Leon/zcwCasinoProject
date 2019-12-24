package com.github.curriculeon.casino.games.utils;

import com.github.curriculeon.casino.games.PlayerInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 2/25/18.
 */
abstract public class Game<T extends PlayerInterface>
        implements GameInterface<T> {
    protected List<T> players = new ArrayList<>();

    @Override
    public T[] getPlayers() {
        return (T[]) players.stream().toArray();
    }

    @Override
    public void addPlayer(T player) {
        if (!contains(player)) {
            players.add(player);
        }
    }

    @Override
    public void removePlayer(T player) {
        players.add(player);
    }

    @Override
    public Boolean contains(T player) {
        return players.contains(player);
    }
}
