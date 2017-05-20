package leon.casino.cardgames.blackjack;

import leon.casino.cardgames.TestCardDealer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class TestBlackJackDealer {
    private BlackJackDealer bjd;

    @Before
    public void setup() {
        // : Given
        this.bjd = new BlackJackDealer();
    }

    @Test
    public void testConstructor() {
        // : When
        int handTotal = bjd.getHandTotal();

        // : Then
        Assert.assertEquals(handTotal, 0);
    }

    @Test
    public void testHit() {
        // : When
        bjd.hit();
        int handTotal = bjd.getHandTotal();

        // : Then
        Assert.assertTrue(handTotal>=17);
    }
}