package leon.casino.cardgames.blackjack.player;

import leon.casino.Profile;
import leon.casino.cardgames.CardPlayer;
import leon.tools.StringAssembler;

/**
 * Created by leon on 5/11/17.
 */
public class BlackJackPlayer extends CardPlayer {
    private final double bet;
    private BlackJackPlayerState state;

    public BlackJackPlayer(Profile profile, Double bet) {
        super(profile);
        this.bet = bet;
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
