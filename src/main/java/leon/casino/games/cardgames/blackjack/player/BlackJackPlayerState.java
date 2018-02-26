package leon.casino.games.cardgames.blackjack.player;

import sun.plugin.dom.exception.InvalidStateException;

import java.util.function.Predicate;

/**
 * Created by leon on 2/25/18.
 */

public enum BlackJackPlayerState {
    BLACKJACK(blackJackPlayer -> blackJackPlayer.getHandTotal() == 21),
    BUST(blackJackPlayer -> blackJackPlayer.getHandTotal() > 21),
    UNDER(blackJackPlayer -> blackJackPlayer.getHandTotal() < 21),
    STAND(null);

    private final Predicate<BlackJackPlayer> condition;

    public Predicate<BlackJackPlayer> getCondition() {
        return condition;
    }

    BlackJackPlayerState(Predicate<BlackJackPlayer> condition) {
        this.condition = condition;
    }

    public static BlackJackPlayerState getState(BlackJackPlayer blackJackPlayer) {
        for (BlackJackPlayerState bjps : BlackJackPlayerState.values()) {
            if (bjps.evaluate(blackJackPlayer)) {
                return bjps;
            }
        }
        throw new InvalidStateException("");
    }

    private boolean evaluate(BlackJackPlayer blackJackPlayer) {
        if (blackJackPlayer.getState().equals(STAND)) {
            return true;
        }
        return condition.test(blackJackPlayer);
    }
}
