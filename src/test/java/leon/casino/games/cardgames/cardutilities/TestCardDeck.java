package leon.casino.games.cardgames.cardutilities;

import org.junit.Test;

/**
 * Created by leon on 10/27/17.
 */
public class TestCardDeck {
    Deck cardDeck = new Deck();

    @Test
    public void testRank() {
        for(Rank cardRank : Rank.values()) {
            for(Card t : cardDeck) {
                t.getRank().equals(cardRank);
            }
        }
    }

    @Test
    public void testSuit() {
        for(Suit cardSuit : Suit.values()) {
            for(Card t : cardDeck) {
                t.getSuit().equals(cardSuit);
            }
        }
    }
}
