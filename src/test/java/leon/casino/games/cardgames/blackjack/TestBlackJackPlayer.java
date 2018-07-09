package leon.casino.games.cardgames.blackjack;

import leon.casino.profile.Profile;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by leon on 5/11/17.
 */
public class TestBlackJackPlayer {

    private Profile testProfile;

    @Before
    public void setup() {
        this.testProfile = new Profile(null, null, null);
    }
    
    @Test
    public void testGetBet() {
        Set s = new HashSet();
        s.add()
        // : Given
        double expected = 9999;
        BlackJackPlayer bjp = new BlackJackPlayer(testProfile, expected);

        // : When
        double actual = bjp.getBetAmount();

        // : Then
        Assert.assertEquals(actual, expected, 0);
    }
}
