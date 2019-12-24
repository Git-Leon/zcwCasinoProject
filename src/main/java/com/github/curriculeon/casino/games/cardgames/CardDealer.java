package com.github.curriculeon.casino.games.cardgames;

/**
 * Created by leon on 5/11/17.
 */

import com.github.curriculeon.casino.games.cardgames.cardutilities.Deck;
import com.github.curriculeon.casino.profile.Profile;

import java.util.Arrays;
import java.util.List;

import static java.lang.Long.*;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class CardDealer extends CardPlayer {
    private final Deck deck;

    public CardDealer() {
        this(new Deck());
    }

    // This constructor exists for testing purposes
    public CardDealer(Deck deck) {
        super(new Profile("DEALER", null, null));
        this.deck = deck;
        this.deck.shuffle();
    }


    public final void deal(CardPlayer player, int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            player.getCard(this.deck);
        }
    }

    public final void deal(Iterable<? extends CardPlayer> players, int numberOfCards) {
        for(CardPlayer player : players) {
            deal(player, numberOfCards);
        }
    }

    public final void deal(CardPlayer[] players, int numberOfCards) {
        deal(Arrays.asList(players), numberOfCards);
    }

}


