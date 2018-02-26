package leon.casino.games;

import leon.casino.DecisionMenu;
import leon.tools.Console;

/**
 * Created by leon on 2/25/18.
 */
public class GameSelectionMenu extends DecisionMenu {
    public GameSelectionMenu() {
        super(GameSelection.values());
    }
    public void display() {
        Console.print("Welcome to the Game Selection Window!");
        Console.print("From here, you can select any of the following options.");
        for (GameSelection gameSelection : GameSelection.values()) {
            Console.print("[" + gameSelection.name() + "]");
        }
    }
}
