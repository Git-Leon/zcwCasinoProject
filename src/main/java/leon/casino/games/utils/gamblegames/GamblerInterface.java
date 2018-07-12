package leon.casino.games.utils.gamblegames;

import leon.casino.games.PlayerInterface;

public interface GamblerInterface extends PlayerInterface {
    Double getBetAmount();
    void setBetAmount(Double amount);
    void increaseBalance(double amount);
    void decreaseBalance(double amount);
}
