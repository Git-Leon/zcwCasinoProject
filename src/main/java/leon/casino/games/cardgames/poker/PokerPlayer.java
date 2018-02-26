package leon.casino.games.cardgames.poker;

import leon.casino.profile.Profile;
import leon.casino.games.cardgames.CardPlayer;

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
