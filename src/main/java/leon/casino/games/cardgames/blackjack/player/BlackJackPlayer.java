package leon.casino.games.cardgames.blackjack.player;

import leon.casino.games.utils.gamblegames.GamblerInterface;
import leon.casino.profile.Profile;
import leon.casino.games.cardgames.CardPlayer;
import leon.tools.StringAssembler;

/**
 * Created by leon on 5/11/17.
 */
public class BlackJackPlayer extends CardPlayer implements GamblerInterface {
    private double bet;
    private BlackJackPlayerState state;

    public BlackJackPlayer(Profile profile) {
        super(profile);
        this.state = BlackJackPlayerState.UNDER;
    }

    @Override
    public void increaseBalance(double amount) {
        profile.increaseBalance(amount);
    }

    @Override
    public void decreaseBalance(double amount) {
        profile.decreaseBalance(amount);
    }

    @Override
    public Double getBetAmount() {
        return this.bet;
    }

    @Override
    public void setBetAmount(Double amount) {
        this.bet = amount;
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
