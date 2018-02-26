package leon.casino.games.utils;

import leon.casino.AsbtractDecisisonMenu;
import leon.tools.Console;

/**
 * Created by leon on 2/25/18.
 */
public class GameSelectionMenu extends AsbtractDecisisonMenu<GameSelection> {
    public GameSelectionMenu() {
        super(GameSelection.values());
    }

    public GameSelection getInput() {
        do {
            String userInputString = Console.getStringInput("Select an option.");
            try {
                return GameSelection.valueOf(userInputString.toUpperCase());
            } catch (IllegalArgumentException iae) {
                super.handleIllegalArgument(userInputString);
            }
        } while(true);
    }
}
