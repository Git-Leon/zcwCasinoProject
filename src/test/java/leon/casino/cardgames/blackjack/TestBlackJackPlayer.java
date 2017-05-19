package leon.casino.cardgames.blackjack;

import leon.casino.TestConstants;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 5/11/17.
 */
public class TestBlackJackPlayer implements TestConstants {

    @Test
    public void testGetBet() {
        // : Given
        double expected = 9999;
        BlackJackPlayer bjp = new BlackJackPlayer(testProfile, expected);

        // : When
        double actual = bjp.getBetAmount();

        // : Then
        Assert.assertEquals(actual, expected, 0);
    }
}
