package leon.casino.cardgames.blackjack;

import leon.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 5/11/17.
 */
public class TestBlackJackPlayer {

    private Profile testProfile;

    @Before
    public void setup() {
        this.testProfile = new Profile("TestProfile", 99999999);
    }
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
