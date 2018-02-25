package leon.casino.cardgames.blackjack.player;

import leon.casino.Decision;
import leon.casino.cardgames.blackjack.BlackJackGame;
import leon.tools.Console;

import java.util.Arrays;
import java.util.function.BiConsumer;

/**
 * Created by leon on 2/25/18.
 */
public enum BlackJackPlayerDecision implements Decision {

    HIT((game, player) -> {
        game.getDealer().deal(player, 1);
    }),

    STAND((game, player) -> {
        player.setState(BlackJackPlayerState.STAND);
    }),


    HAND((game, player) -> {
        player.printHand();
    }),

    TABLE((game, player) -> {
        game.printTable();
    });


    private final BiConsumer<BlackJackGame, BlackJackPlayer> operation;

    BlackJackPlayerDecision(BiConsumer<BlackJackGame, BlackJackPlayer> operation) {
        this.operation = operation;
    }

    public void perform(BlackJackGame game, BlackJackPlayer player) {
        operation.accept(game, player);
    }

    public static void printValues() {
        Console.println("Displaying valid player decisions...");
        Console.println(Arrays.toString(BlackJackPlayerDecision.values()));
    }
}
