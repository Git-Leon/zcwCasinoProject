package leon.casino.games.cardgames.poker;

import leon.casino.AbstractDecisisonMenu;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayerState;
import leon.casino.profile.Profile;
import leon.tools.StringAssembler;

abstract public class PokerPlayerDecisionMenu extends AbstractDecisisonMenu<PokerPlayerDecision, PokerPlayer> {
    public PokerPlayerDecisionMenu(PokerPlayerDecision[] enumerations, PokerPlayer playerInterface) {
        super(enumerations, playerInterface);
    }

    @Override
    public PokerPlayerDecision getInput() {
        return null;
    }

    @Override
    public String toString() {
        // profile
        Profile playerProfile = player.getProfile();
        double playerBalance = playerProfile.getBalance();
        String playerName = playerProfile.getName();

        // card player
        int playerHandTotal = player.getHandTotal();
        double playerBet = player.getBetAmount();

        // black jack card player
        PokerPlayerState playerState = PokerPlayerState.getState(player);

        return new StringAssembler("\n")
                .append(super.toString())
                .append("Profile Name: [ %s ]", playerName)
                .append("Your current balance is [ %s ].", playerBalance)
                .append("Your current hand-total is [ %s ].", playerHandTotal)
                .append("You have currently bet an amount of [ %s ].", playerBet)
                .append("Your current run-state is [ %s ].", playerState.name())
                .append("What action would you like to take?")
                .toString();
    }
}
