package leon.casino.games.cardgames.poker;

import leon.casino.games.utils.gamblegames.GamblerInterface;
import leon.casino.profile.Profile;
import leon.casino.games.cardgames.CardPlayer;

public class PokerPlayer extends CardPlayer implements GamblerInterface {
    private Double betAmount;

    PokerPlayer(Profile profile) {
        super(profile);
    }

    void setBetAmount(double newBetValue) {
        this.betAmount = newBetValue;
    }

    public Double getBetAmount() {
        return betAmount;
    }

    @Override
    public void increaseBalance(double amount) {
        profile.increaseBalance(amount);
    }

    @Override
    public void decreaseBalance(double amount) {
        increaseBalance(-amount);
    }
}
