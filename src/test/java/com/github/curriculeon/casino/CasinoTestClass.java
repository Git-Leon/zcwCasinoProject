package com.github.curriculeon.casino;

import com.github.curriculeon.casino.games.cardgames.CardDealer;
import com.github.curriculeon.casino.games.cardgames.CardPlayer;
import com.github.curriculeon.casino.games.cardgames.cardutilities.Deck;
import com.github.curriculeon.casino.profile.Profile;
import com.github.curriculeon.casino.profile.ProfileInterface;
import org.junit.Before;

/**
 * Created by leon on 5/19/17.
 */
public class CasinoTestClass {

    Deck testDeck = new Deck();
    ProfileInterface testProfile = new Profile(null, null, null);
    CardPlayer testCardPlayer = new CardPlayer(testProfile);
    CardDealer testCardDealer = new CardDealer(testDeck);

    @Before
    public void setup() {
    }
}
