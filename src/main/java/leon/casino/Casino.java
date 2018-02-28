package leon.casino;


import leon.casino.profile.ProfileManager;
import leon.tools.Console;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public final class Casino extends AbstractDecisisonMenu<CasinoDecision> {
    ProfileManager profileManager = new ProfileManager();

    public Casino() {
        super(CasinoDecision.values());
    }

    public final void start() {
        while (true) {
            getInput().perform(this, profileManager);
        }
    }

    @Override
    public CasinoDecision getInput() {
        return CasinoDecision.valueOf(getInputFromUser().toUpperCase());
    }
}