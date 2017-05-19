package leon.casino.cardgames.cardutilities;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by leon.hunter on 2/1/2017.
 */

public class Deck extends Stack<Card> {
    public Deck() {
        super();
        final String[] suits = {"Hearts ♥", "Diamonds ♦", "Clubs ♣", "Spades ♠"};

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < 13; j++) {
                Face face = new Face(j);
                Suit suit = new Suit(suits[i]);

                this.push(new Card(face, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this);
    }
}