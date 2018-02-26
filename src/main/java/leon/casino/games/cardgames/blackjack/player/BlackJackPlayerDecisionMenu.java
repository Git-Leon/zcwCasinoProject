package leon.casino.games.cardgames.blackjack.player;

import leon.casino.AsbtractDecisisonMenu;
import leon.casino.games.cardgames.blackjack.BlackJackGame;
import leon.casino.profile.Profile;
import leon.tools.Console;
import leon.tools.StringAssembler;

/**
 * Created by leon on 2/25/18.
 */
public class BlackJackPlayerDecisionMenu extends AsbtractDecisisonMenu<BlackJackPlayerDecision> {
    private final BlackJackPlayer player;
    private final BlackJackGame game;

    public BlackJackPlayerDecisionMenu(BlackJackGame game, BlackJackPlayer player) {
        super(BlackJackPlayerDecision.values());
        this.player = player;
        this.game = game;
    }


    @Override
    public String toString() {
        // profile
        Profile playerProfile = player.getProfile();
        String playerName = playerProfile.getName();

        // gambling
        double playerBalance = playerProfile.getBalance();
        int playerBet = player.getBetAmount().intValue();

        // card player
        int playerHandTotal = player.getHandTotal();
        int dealerHandTotal = game.getDealer().getHandTotal();

        // black jack card player
        BlackJackPlayerState playerState = BlackJackPlayerState.getState(player);

        return new StringAssembler("\n")
                .append("Welcome to the BlackJack Player-Decision Menu, [ %s ]!", playerName.toUpperCase())
                .append("Your current balance is [ %s ]", playerBalance)
                .append("Your current hand-total is [ %s ]", playerHandTotal)
                .append("You have currently bet an amount of [ %s ].", playerBet)
                .append("Your current run-state is [ %s ].", playerState.name())
                .append("What action would you like to take?")
                .toString();
    }

    @Override
    public BlackJackPlayerDecision getInput() {
        BlackJackPlayerDecision decision = null;
        String userInput = null;
        try {
            userInput = Console.getStringInput();
            decision = BlackJackPlayerDecision.valueOf(userInput);
            decision.perform(game, player);
        } catch (IllegalArgumentException iae) {
            super.handleIllegalArgument(userInput);
        }
        return decision;
    }
}
