package leon.casino;

import leon.casino.cardgames.CardDealer;
import leon.casino.cardgames.CardPlayer;
import leon.casino.cardgames.cardutilities.Deck;
import org.junit.Before;

/**
 * Created by leon on 5/19/17.
 */
public class CasinoTestClass {

    Deck testDeck = new Deck();
    Profile testProfile = new Profile("TestProfile", 99999999);
    CardPlayer testCardPlayer = new CardPlayer(testProfile);
    CardDealer testCardDealer = new CardDealer(testDeck);

    @Before
    public void setup() {
    }
}
