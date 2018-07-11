package leon.casino.games.cardgames.blackjack.gamenginetests;

import leon.casino.games.cardgames.blackjack.BlackJackGame;
import leon.casino.games.cardgames.blackjack.BlackJackGameEngine;
import leon.casino.profile.Profile;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestBlackJackGameEngine {
    @Test
    public void uponConstructionEnsureEachProfileGeneratesAPlayer() {
        // Given
        Profile profile1 = new Profile(null, null, 1L);
        Profile profile2 = new Profile(null, null, 2L);
        Profile profile3 = new Profile(null, null, 3L);
        List<Profile> profileList = Arrays.asList(profile1, profile2, profile3);

        // When
        BlackJackGameEngine blackJackGameEngine = new BlackJackGameEngine(profileList);

        // Then
        BlackJackGame blackJackGame = blackJackGameEngine.getGame();
        blackJackGame.getPlayers().forEach(player ->{
            Profile profile = player.getProfile();
            Assert.assertTrue(profileList.contains(profile));
        });
        Assert.assertEquals(profileList.size(), blackJackGame.getPlayers().size());
    }

    @Test
    public void t() {
        // Given
        Profile profile1 = new Profile(null, null, 1L);
        Profile profile2 = new Profile(null, null, 2L);
        Profile profile3 = new Profile(null, null, 3L);
        List<Profile> profileList = Arrays.asList(profile1, profile2, profile3);

        // When
        BlackJackGameEngine blackJackGameEngine = new BlackJackGameEngine(profileList);

        // Then
        BlackJackGame blackJackGame = blackJackGameEngine.getGame();
        blackJackGame.getPlayers().forEach(player ->{
            Profile profile = player.getProfile();
            Assert.assertTrue(profileList.contains(profile));
        });
        Assert.assertEquals(profileList.size(), blackJackGame.getPlayers().size());
        blackJackGame.
    }
}
