package leon.casino;

import org.junit.Assert;
import org.junit.Test;

public class TestProfile implements TestConstants {

    @Test
    public void testGetBalance() {
        Assert.assertEquals(testProfile.getBalance(), 99999999, 100);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(testProfile.getName(), "TestProfile");
    }
}
