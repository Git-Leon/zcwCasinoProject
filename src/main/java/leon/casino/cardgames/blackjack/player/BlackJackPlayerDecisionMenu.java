package leon.casino.cardgames.blackjack.player;

import leon.casino.cardgames.blackjack.BlackJackGame;
import leon.tools.Console;

/**
 * Created by leon on 2/25/18.
 */
public class BlackJackPlayerDecisionMenu {
    private final BlackJackPlayer player;
    private final BlackJackGame game;

    public BlackJackPlayerDecisionMenu(BlackJackGame game, BlackJackPlayer player) {
        this.player = player;
        this.game = game;
    }

    public void getMenu() {
        do {
            BlackJackPlayerDecision.printValues();
            String moveDecision = Console.getStringInput("What action would you like to take?");
            try {
                BlackJackPlayerDecision.valueOf(moveDecision.toUpperCase()).perform(game, player);
            } catch (IllegalArgumentException iae) {
                Console.println("Invalid input! Try again!");
                continue;
            }
            break;
        } while (true);
    }
}
