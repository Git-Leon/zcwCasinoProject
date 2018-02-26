package leon.casino;


import leon.casino.games.utils.GameSelection;
import leon.casino.games.utils.GameSelectionMenu;
import leon.casino.profile.Profile;
import leon.casino.profile.ProfileManager;
import leon.casino.profile.ProfileManagerMenu;
import leon.casino.profile.ProfileManagerSelection;
import leon.tools.Console;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public final class Casino extends AsbtractDecisisonMenu<CasinoDecision> {
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
        super.display();
        String userInput = Console.getStringInput("What would you like to do?");
        return CasinoDecision.valueOf(userInput.toUpperCase());
    }
}