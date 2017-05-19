package leon.casino.cardgames.blackjack;

import leon.casino.Profile;
import leon.casino.cardgames.CardPlayer;

/**
 * Created by leon on 5/11/17.
 */
public class BlackJackPlayer extends CardPlayer {
    private final double bet;
    private boolean isFinished;

    public BlackJackPlayer(Profile profile, Double bet) {
        super(profile);
        this.bet = bet;
        this.isFinished = false;
    }

    public Double getBetAmount() {
        return this.bet;
    }

    // TODO - replace with BlackJackPlayerState enum
    public String getState() {
        int handTotal = getHandTotal();
        if (isFinished) {
            return "done";
        } else if (handTotal == 21) {
            return "blackjack";
        } else if (handTotal > 21) {
            return "bust";
        } else {
            return "under";
        }
    }

    public void finish() {
        this.isFinished = true;
    }


}
