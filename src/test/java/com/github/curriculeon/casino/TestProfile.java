package com.github.curriculeon.casino;

import com.github.curriculeon.casino.profile.Profile;
import com.github.curriculeon.casino.profile.ProfileInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestProfile {
    private ProfileInterface testProfile;

    @Before
    public void setup() {
        this.testProfile = new Profile(null, null, null);
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
