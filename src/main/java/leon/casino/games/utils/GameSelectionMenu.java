package leon.casino.games.utils;

import leon.casino.AbstractDecisisonMenu;

/**
 * Created by leon on 2/25/18.
 */
public class GameSelectionMenu extends AbstractDecisisonMenu<GameSelection> {
    public GameSelectionMenu() {
        super(GameSelection.values());
    }

    public GameSelection getInput() {
        return GameSelection.valueOf(getInputFromUser().toUpperCase());
    }
}