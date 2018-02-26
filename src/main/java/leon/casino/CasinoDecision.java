package leon.casino;

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
public enum CasinoDecision {
    CREATE((casino, profileManager) -> {
        int numberOfProfiles = Console.getIntegerInput("How many player profiles would you like to create?");
        profileManager.createProfiles(numberOfProfiles);
    }),
    
    MANAGE_PROFILE((casino, profileManager) -> {
        ProfileManagerMenu profileManagerMenu = new ProfileManagerMenu();
        profileManagerMenu.display();
        ProfileManagerSelection profileManagerSelection = profileManagerMenu.getInput();
        profileManagerSelection.perform();
    }),
    
    SELECT_GAME((casino, profileManager) -> {
        GameSelectionMenu gameSelectionMenu = new GameSelectionMenu();
        gameSelectionMenu.display();
        GameSelection gameSelection = gameSelectionMenu.getInput();
        gameSelection.perform();
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