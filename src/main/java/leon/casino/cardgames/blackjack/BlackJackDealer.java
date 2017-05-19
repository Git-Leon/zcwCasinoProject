package leon.casino.cardgames.blackjack;

import leon.casino.cardgames.CardDealer;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class BlackJackDealer extends CardDealer {
    public void hit() {
        while (getHandTotal() < 17) {
            deal(this, 1);
        }
    }
}