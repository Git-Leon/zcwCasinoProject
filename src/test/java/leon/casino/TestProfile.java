package leon.casino;

import leon.casino.profile.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestProfile {
    private Profile testProfile;

    @Before
    public void setup() {
        this.testProfile = new Profile(null, null, null);
    }

    @Test
    public void testIncreaseBalance() {
        // Given
        Profile profile = new Profile(null, 0.0, null);
        Double expected = 9999.0;

        // When
        profile.increaseBalance(expected);
        Double actual = profile.getBalance();

        // Then
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void testGetName() {
        // Given
        String expected = "Leon";
        Profile profile = new Profile(expected, null, null);

        // When
        String actual = profile.getName();

        // Then
        Assert.assertEquals(expected, actual);
    }
}
