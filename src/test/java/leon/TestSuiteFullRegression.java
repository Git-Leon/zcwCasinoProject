package leon;

/**
 * Created by leon on 5/19/17.
 */
import leon.casino.TestProfile;
import leon.casino.games.cardgames.TestCardDealer;
import leon.casino.games.cardgames.TestCardPlayer;
import leon.casino.games.cardgames.blackjack.TestBlackJackDealer;
import leon.casino.games.cardgames.blackjack.TestBlackJackPlayer;
import leon.casino.games.cardgames.cardutilities.TestCardDeck;
import leon.casino.games.cardgames.poker.TestPokerHand;
import leon.casino.games.cardgames.poker.TestPokerPlayer;
import leon.casino.games.mechanicalgames.TestMechanicalPlayer;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestBlackJackDealer.class,
        TestBlackJackPlayer.class,
        TestCardDeck.class,
        TestPokerHand.class,
        TestPokerPlayer.class,
        TestCardDealer.class,
        TestCardPlayer.class,
        TestMechanicalPlayer.class,
        TestProfile.class
})

public class TestSuiteFullRegression {
}
