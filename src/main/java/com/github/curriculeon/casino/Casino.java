package com.github.curriculeon.casino;


import com.github.curriculeon.casino.profile.ProfileManager;
import com.github.curriculeon.casino.profile.ProfileManagerInterface;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public final class Casino extends AbstractDecisionMenu<CasinoDecision> implements CasinoInterface {
    private ProfileManagerInterface profileManager = new ProfileManager();

    public Casino() {
        super(CasinoDecision.values());
    }

    @Override
    public final void start() {
        while (true) {
            getInput().perform(this);
        }
    }

    @Override
    public final ProfileManagerInterface getProfileManager() {
        return profileManager;
    }

}