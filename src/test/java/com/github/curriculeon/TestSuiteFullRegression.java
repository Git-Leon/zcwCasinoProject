package com.github.curriculeon;

/**
 * Created by leon on 5/19/17.
 */
import com.github.curriculeon.casino.TestProfile;
import com.github.curriculeon.casino.games.cardgames.TestCardDealer;
import com.github.curriculeon.casino.games.cardgames.TestCardPlayer;
import com.github.curriculeon.casino.games.cardgames.blackjack.TestBlackJackDealer;
import com.github.curriculeon.casino.games.cardgames.blackjack.TestBlackJackPlayer;
import com.github.curriculeon.casino.games.cardgames.cardutilities.TestCardDeck;
import com.github.curriculeon.casino.games.cardgames.poker.TestPokerHand;
import com.github.curriculeon.casino.games.cardgames.poker.TestPokerPlayer;
import com.github.curriculeon.casino.games.mechanicalgames.TestMechanicalPlayer;
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
