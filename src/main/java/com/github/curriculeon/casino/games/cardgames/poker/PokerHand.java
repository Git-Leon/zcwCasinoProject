package com.github.curriculeon.casino.games.cardgames.poker;

import com.github.curriculeon.casino.games.cardgames.cardutilities.Card;
import com.github.curriculeon.casino.games.cardgames.cardutilities.Suit;

import java.util.ArrayList;

/**
 * Created by cameronsima on 5/9/17.
 */
public class PokerHand {
    public enum HandType {HIGHCARD, PAIR, TWOPAIR, THREEOFAKIND, STRAIGHT, FLUSH, FULLHOUSE, FOUROFAKIND, STRAIGHTFLUSH}

    private final ArrayList<Card> cards;

    public PokerHand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    HandType getHandType() {
        int switchNum = numberOfRanksPresent();
        switch (switchNum) {
            case 2:
                return twoRankHandChooser();
            case 3:
                return threeRankHandChooser();
            case 4:
                return fourRankHandChooser();
            case 5:
                return fiveRankHandChooser();
            default:
                return null;
        }
    }

    public boolean hasFlush() {
        Suit suit = cards.get(0).getSuit();
        for (Card c : cards) {
            if (c.getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    public boolean hasStraight() {
        int ordinal = cards.get(0).getValue();
        for (int i = 1; i < 5; i++) {
            ordinal++;
            if (cards.get(i).getValue() != ordinal) {
                return false;
            }
        }
        return true;
    }

    public int countRank(int rank) {
        int count = 0;
        for (Card c : cards) {
            if (c.getValue() == rank) {
                count++;
            }
        }
        return count;
    }

    public int numberOfRanksPresent() {
        ArrayList<Integer> ranksPresent = new ArrayList<>();
        for (Card c : cards){
            if (!ranksPresent.contains(c.getValue())) {
                ranksPresent.add(c.getValue());
            }
        }
        return ranksPresent.size();
    }

    public HandType fiveRankHandChooser() {
        if (hasStraight()) {
            if (hasFlush()) {
                return HandType.STRAIGHTFLUSH;
            } else {
                return HandType.STRAIGHT;
            }
        } else if (hasFlush()) {
            return HandType.FLUSH;
        } else {
            return HandType.HIGHCARD;
        }
    }

    public HandType fourRankHandChooser() {
        return HandType.PAIR;
    }

    public HandType threeRankHandChooser() {
        if (hasTriple()) {
            return HandType.THREEOFAKIND;
        } else {
            return HandType.TWOPAIR;
        }
    }

    public HandType twoRankHandChooser() {
        int rank = cards.get(0).getValue();
        if(cards.get(1).getValue() == rank) {
            return HandType.FULLHOUSE;
        }
        return HandType.FOUROFAKIND;
    }

    boolean hasTriple() {
        int rank = cards.get(2).getValue();
        if (countRank(rank) == 3) {
            return true;
        }
        return false;
    }

}
