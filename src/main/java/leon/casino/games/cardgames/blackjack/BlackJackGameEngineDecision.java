package leon.casino.games.cardgames.blackjack;

import leon.casino.profile.Profile;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayer;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayerDecisionMenu;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayerState;

import java.util.Optional;
import java.util.function.BiConsumer;

/**
 * Created by leon on 2/25/18.
 */
public enum BlackJackGameEngineDecision implements BlackJackGameDecision {
    BLACKJACK((game, player) -> {
        /** Increase player's earnings by `player.getBetAmount()`
         * set state of player to be BLACKJACK */
        player.getProfile().increaseBalance(player.getBetAmount());
        player.setState(BlackJackPlayerState.BLACKJACK);
    }),

    BUST((game, player) -> {
        /** Decrease player's earnings by `player.getBetAmount()`
         * set state of player to be BUST */
        player.getProfile().decreaseBalance(player.getBetAmount());
        player.setState(BlackJackPlayerState.BUST);
    }),


    UNDER((game, player) -> {
        /** Create a decision menu to get input from user */
        BlackJackPlayerDecisionMenu blackJackPlayerDecisionMenu = new BlackJackPlayerDecisionMenu(game, player);
        blackJackPlayerDecisionMenu.getInput();
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

    BlackJackGameEngineDecision(BiConsumer<BlackJackGame, BlackJackPlayer> operation) {
        this.operation = operation;
    }

    /**
     * @param game The game to operate on
     * @param player The player to operate on
     * @return Void; this method must conform to its interface, but does not return anything
     */
    public Void perform(BlackJackGame game, BlackJackPlayer player) {
        operation.accept(game, player);
        BlackJackPlayerState currentPlayerState = BlackJackPlayerState.valueOf(this.name());
        player.setState(currentPlayerState);
        return null;
    }

    /**
     * @param playerState state of player
     * @return the decision to be actioned after evaluating the player's state
     */
    public static BlackJackGameEngineDecision getDecision(BlackJackPlayerState playerState) {
        return BlackJackGameEngineDecision.valueOf(playerState.name());
    }
}
