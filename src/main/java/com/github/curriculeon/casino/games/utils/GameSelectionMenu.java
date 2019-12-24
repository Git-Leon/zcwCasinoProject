package com.github.curriculeon.casino.games.utils;

import com.github.curriculeon.casino.AbstractDecisionMenu;

/**
 * Created by leon on 2/25/18.
 */
public class GameSelectionMenu extends AbstractDecisionMenu<GameSelection> {
    public GameSelectionMenu() {
        super(GameSelection.values());
    }
}