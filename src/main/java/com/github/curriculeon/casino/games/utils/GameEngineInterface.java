package com.github.curriculeon.casino.games.utils;

import com.github.curriculeon.casino.games.PlayerInterface;

/**
 * Created by leon on 2/25/18.
 */
public interface GameEngineInterface<
        GameTypePlayer extends PlayerInterface,
        GameType extends GameInterface<GameTypePlayer>>
        extends Runnable {

    GameType getGame();
    void evaluateTurn(GameTypePlayer player);
    void run();
}
