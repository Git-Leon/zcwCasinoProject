package leon.casino.cardgames.cardutilities;

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by leon.hunter on 2/1/2017.
 */

public class Deck implements Iterable<Card> {
    private Stack<Card> cardStack = new Stack<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suit);
                cardStack.push(card);
            }
        }
    }

    public Card pop() {
        return cardStack.pop();
    }

    public Card push(Card card) {
        return cardStack.push(card);
    }

    public Card peek() {
        return cardStack.peek();
    }

    public boolean isEmpty() {
        return cardStack.isEmpty();
    }

    public void shuffle() {
        Collections.shuffle(cardStack);
    }

    @Override
    public Iterator iterator() {
        return cardStack.iterator();
    }

    public int size() {
        return cardStack.size();
    }
}