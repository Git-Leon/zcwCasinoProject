package leon.casino.cardgames;

import leon.casino.TestConstants;
import leon.casino.cardgames.cardutilities.Deck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class TestCardPlayer implements TestConstants {
    Deck testDeck;
    CardPlayer testCardPlayer;

    @Before
    public void setup() {
        this.testDeck = new Deck();
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
