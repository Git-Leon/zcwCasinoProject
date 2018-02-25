package leon.casino.cardgames.blackjack;

import leon.casino.Decision;
import leon.casino.Profile;
import leon.casino.cardgames.blackjack.player.BlackJackPlayer;
import leon.casino.cardgames.blackjack.player.BlackJackPlayerDecision;
import leon.casino.cardgames.blackjack.player.BlackJackPlayerDecisionMenu;
import leon.casino.cardgames.blackjack.player.BlackJackPlayerState;
import leon.tools.Console;

import java.util.Arrays;
import java.util.function.BiConsumer;

/**
 * Created by leon on 2/25/18.
 */

public enum BlackJackGameDecision implements Decision {

    BLACKJACK((game, player) -> {
        player.getProfile().increaseBalance(player.getBetAmount());
        player.setState(BlackJackPlayerState.BLACKJACK);
    }),

    BUST((game, player) -> {
        player.getProfile().decreaseBalance(player.getBetAmount());
        player.setState(BlackJackPlayerState.BUST);
    }),


    UNDER((game, player) -> {
        BlackJackPlayerDecisionMenu blackJackPlayerDecisionMenu = new BlackJackPlayerDecisionMenu(game, player);
        blackJackPlayerDecisionMenu.getMenu();
    }),


    STAND((game, player) -> {
        Profile playerProfile = player.getProfile();
        double playerBet = player.getBetAmount();
        int playerHandTotal = player.getHandTotal();
        int dealerHandTotal = game.getDealer().getHandTotal();
        int rewardMultiplier = playerHandTotal > dealerHandTotal ? 1 : -1;

        playerProfile.increaseBalance(rewardMultiplier * playerBet);
    });



    private final BiConsumer<BlackJackGame, BlackJackPlayer> operation;

    BlackJackGameDecision(BiConsumer<BlackJackGame, BlackJackPlayer> operation) {
        this.operation = operation;
    }

    public void perform(BlackJackGame game, BlackJackPlayer player) {
        operation.accept(game, player);
        player.setState(getPlayerState());
    }

    public static void printValues() {
        Console.println(Arrays.toString(BlackJackPlayerDecision.values()));
    }

    public BlackJackPlayerState getPlayerState() {
        return BlackJackPlayerState.valueOf(this.name());
    }

    public static BlackJackGameDecision getDecision(BlackJackPlayerState playerState) {
        return BlackJackGameDecision.valueOf(playerState.name());
    }
}
