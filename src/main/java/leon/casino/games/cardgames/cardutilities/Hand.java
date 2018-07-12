package leon.casino.games.cardgames.cardutilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hand implements Iterable<Card> {
    private List<Card> cardList = new ArrayList<>();

    public boolean isEmpty() {
        return size() < 1;
    }

    public void remove(Card card) {
        cardList.remove(card);
    }

    public void add(Card card) {
        cardList.add(card);
    }

    public boolean contains(Card card) {
        return cardList.contains(card);
    }

    public int size() {
        return cardList.size();
    }

    @Override
    public Iterator<Card> iterator() {
        return cardList.iterator();
    }

    public String toString() {
        return cardList.toString();
    }
}
