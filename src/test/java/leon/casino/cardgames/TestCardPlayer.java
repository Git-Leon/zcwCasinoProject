package leon.casino.cardgames;

import leon.casino.Profile;
import leon.casino.cardgames.cardutilities.Deck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class TestCardPlayer {
    private Deck testDeck;
    private CardPlayer testCardPlayer;
    private Profile testProfile;


    @Before
    public void setup() {
        this.testDeck = new Deck();
        this.testProfile = new Profile("TestProfile", 99999999);
        this.testCardPlayer = new CardPlayer(testProfile);
    }

    @Test
    public void testGetCard() {
        // : Given
        int startSize = testDeck.size();

        // : When
        testCardPlayer.getCard(testDeck);
        int endSize = testDeck.size();

        // : Then
        Assert.assertEquals(startSize - 1, endSize);
    }

    @Test
    public void testGetHandTotal() {
        // : Given
        int startTotal = testCardPlayer.getHandTotal();
        assert (startTotal == 0); // ensure the hand is empty

        // : When
        testCardPlayer.getCard(testDeck);
        int endTotal = testCardPlayer.getHandTotal();

        // : Then
        Assert.assertTrue(startTotal < endTotal);
    }
}
