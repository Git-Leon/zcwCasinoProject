package leon.casino.cardgames.cardutilities;

import leon.casino.TestConstants;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 5/17/17.
 */ // TODO - Implement tests
public class TestDeck implements TestConstants {

    @Test
    public void testConstructor() {
        Deck testDeck = new Deck();
        Assert.assertEquals(52, testDeck.size());
    }
}
