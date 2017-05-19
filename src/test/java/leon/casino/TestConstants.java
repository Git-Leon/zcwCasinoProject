package leon.casino;

import leon.casino.Profile;
import leon.casino.cardgames.CardDealer;
import leon.casino.cardgames.CardPlayer;
import leon.casino.cardgames.cardutilities.Deck;

/**
 * Created by leon on 5/17/17.
 */
public interface TestConstants {
    Deck testDeck = new Deck();
    Profile testProfile = new Profile("TestProfile", 99999999);
    CardPlayer testCardPlayer = new CardPlayer(testProfile);
    CardDealer testCardDealer = new CardDealer(testDeck);
}
