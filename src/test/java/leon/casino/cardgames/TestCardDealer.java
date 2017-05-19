package leon.casino.cardgames;

/**
 * Created by leon on 5/11/17.
 */

import leon.casino.TestConstants;
import leon.tools.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class TestCardDealer implements TestConstants {
    @Test
    public final void testDeal() {
        // : Given
        int startSize = testDeck.size();
        int randomNumber = RandomUtils.createInteger(1,26);

        // : When
        testCardDealer.deal(testCardPlayer, randomNumber);
        int endSize = testDeck.size();

        // : Then
        Assert.assertEquals(endSize, startSize - randomNumber);
    }
}