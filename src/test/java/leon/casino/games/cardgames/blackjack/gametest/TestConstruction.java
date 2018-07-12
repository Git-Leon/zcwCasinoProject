package leon.casino.games.cardgames.blackjack.gametest;

import leon.casino.games.cardgames.blackjack.BlackJackGame;
import leon.casino.games.cardgames.blackjack.BlackJackGameEngine;
import leon.casino.profile.Profile;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestConstruction {
    private BlackJackGame blackJackGame;
    private List<Profile> profileList;

    public void setup() {
        // Given
        Profile profile1 = new Profile(null, null, 1L);
        Profile profile2 = new Profile(null, null, 2L);
        Profile profile3 = new Profile(null, null, 3L);
        this.profileList = Arrays.asList(profile1, profile2, profile3);
        this.blackJackGame = new BlackJackGameEngine(profileList).getGame();
    }

    @Test
    public void ensureEachProfileGeneratesAPlayer() {
        blackJackGame.getPlayers().forEach(player ->{
            Profile profile = player.getProfile();
            Assert.assertTrue(profileList.contains(profile));
        });
        Assert.assertEquals(profileList.size(), blackJackGame.getPlayers().size());
    }
}