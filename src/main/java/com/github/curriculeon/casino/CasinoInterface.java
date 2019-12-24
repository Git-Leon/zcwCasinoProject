package com.github.curriculeon.casino;

import com.github.curriculeon.casino.profile.ProfileManagerInterface;

public interface CasinoInterface extends Menu {
    void start();

    ProfileManagerInterface getProfileManager();

    CasinoDecision getInput();
}
