package com.github.curriculeon.casino.games.cardgames.blackjack;

import com.github.curriculeon.casino.profile.Profile;
import com.github.curriculeon.casino.games.cardgames.blackjack.player.BlackJackPlayer;
import com.github.curriculeon.casino.profile.ProfileInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 5/11/17.
 */
public class TestBlackJackPlayer {

    private ProfileInterface testProfile;

    @Before
    public void setup() {
        this.testProfile = new Profile(null, null, null);
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
