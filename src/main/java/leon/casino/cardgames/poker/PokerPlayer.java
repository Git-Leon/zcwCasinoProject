package leon.casino.cardgames.poker;

import leon.casino.Profile;
import leon.casino.cardgames.CardPlayer;

public class PokerPlayer extends CardPlayer {
    private Double betAmount;

    PokerPlayer(Profile profile) {
        super(profile);
    }

    Double getBetAmount() {
        return this.betAmount;
    }

    void setBetAmount(double newBetValue) {
        this.betAmount = newBetValue;
    }

    void collectEarnings(double earningValue) {
        super.profile.increaseBalance(earningValue);
    }
}
