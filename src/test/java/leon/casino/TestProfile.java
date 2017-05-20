package leon.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestProfile {
    private Profile testProfile;

    @Before
    public void setup() {
        this.testProfile = new Profile("TestProfile", 99999999);
    }

    @Test
    public void testGetBalance() {
        Assert.assertEquals(testProfile.getBalance(), 99999999, 0);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(testProfile.getName(), "TestProfile");
    }
}
