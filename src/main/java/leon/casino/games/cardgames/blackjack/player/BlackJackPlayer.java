package leon.casino.games.cardgames.blackjack.player;

import leon.casino.profile.Profile;
import leon.casino.games.cardgames.CardPlayer;
import leon.tools.StringAssembler;

/**
 * Created by leon on 5/11/17.
 */
public class BlackJackPlayer extends CardPlayer {
    private double bet;
    private BlackJackPlayerState state;

    public BlackJackPlayer(Profile profile) {
        super(profile);
        this.state = BlackJackPlayerState.UNDER;
    }

    public Double getBetAmount() {
        return this.bet;
    }

    public BlackJackPlayerState getState() {
        return this.state;
    }

    public void setState(BlackJackPlayerState state) {
        this.state = state;
    }

    public String toString() {
        return new StringAssembler("\n")
                .append("Player name = %s", profile.getName())
                .append("Player balance = %s", profile.getBalance())
                .append("Player hand total = %s", getHandTotal())
                .append("Bet amount = %s", getBetAmount())
                .toString();
    }
}
