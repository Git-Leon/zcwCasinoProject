package leon;

/**
 * Created by leon on 5/19/17.
 */
import leon.casino.TestProfile;
import leon.casino.cardgames.TestCardDealer;
import leon.casino.cardgames.TestCardPlayer;
import leon.casino.cardgames.blackjack.TestBlackJackDealer;
import leon.casino.cardgames.blackjack.TestBlackJackPlayer;
import leon.casino.cardgames.cardutilities.TestCardDeck;
import leon.casino.cardgames.poker.TestPokerHand;
import leon.casino.cardgames.poker.TestPokerPlayer;
import leon.casino.mechanicalgames.TestMechanicalPlayer;
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
