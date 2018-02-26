package leon.casino;

import leon.casino.games.cardgames.CardDealer;
import leon.casino.games.cardgames.CardPlayer;
import leon.casino.games.cardgames.cardutilities.Deck;
import leon.casino.profile.Profile;
import org.junit.Before;

/**
 * Created by leon on 5/19/17.
 */
public class CasinoTestClass {

    Deck testDeck = new Deck();
    Profile testProfile = new Profile(null, null, null);
    CardPlayer testCardPlayer = new CardPlayer(testProfile);
    CardDealer testCardDealer = new CardDealer(testDeck);

    @Before
    public void setup() {
    }
}
