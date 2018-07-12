package leon.casino;

import leon.casino.games.utils.GameEngineInterface;
import leon.casino.games.utils.GameSelection;
import leon.casino.games.utils.GameSelectionMenu;
import leon.casino.profile.ProfileManager;
import leon.casino.profile.ProfileManagerMenu;
import leon.casino.profile.ProfileManagerSelection;
import leon.tools.Console;

import java.util.function.BiConsumer;

/**
 * Created by leon on 2/26/18.
 */
public enum CasinoDecision implements Decision {
    MANAGE_PROFILE((casino, profileManager) -> {
        ProfileManagerMenu profileManagerMenu = new ProfileManagerMenu();
        ProfileManagerSelection profileManagerSelection = profileManagerMenu.getInput();
        profileManagerSelection.perform(profileManager);
    }),
    
    SELECT_GAME((casino, profileManager) -> {
        GameSelectionMenu gameSelectionMenu = new GameSelectionMenu();
        GameSelection gameSelection = gameSelectionMenu.getInput();
        GameEngineInterface gameEngine = gameSelection.create(profileManager.profiles);
        gameEngine.run();
    }),
    
    EXIT((casino, profileManager) -> {
        profileManager.printProfilesInformation();
    });


    private final BiConsumer<Casino, ProfileManager> profileConsumer;

    CasinoDecision(BiConsumer<Casino, ProfileManager> profileConsumer) {
        this.profileConsumer = profileConsumer;
    }

    public void perform(Casino casino, ProfileManager profileManager) {
        profileConsumer.accept(casino, profileManager);
    }
}