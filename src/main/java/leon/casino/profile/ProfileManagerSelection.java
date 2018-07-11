package leon.casino.profile;

import leon.casino.Casino;
import leon.casino.Decision;
import leon.tools.Console;

import java.util.function.BiConsumer;

/**
 * Created by leon on 2/25/18.
 */
public enum ProfileManagerSelection {
    SELECT((casino, profileManager) -> {
        int numberOfProfiles = Console.getIntegerInput("How many player profileList would you like to create?");
        profileManager.createProfiles(numberOfProfiles);
    }),

    CREATE((casino, profileManage) -> {
        profileManage.createProfile();
    });

    private final BiConsumer<Casino, ProfileManager> profileConsumer;

    ProfileManagerSelection(BiConsumer<Casino, ProfileManager> profileConsumer) {
        this.profileConsumer = profileConsumer;
    }

    public void perform(Casino casino, ProfileManager profileManager) {
        profileConsumer.accept(casino, profileManager);
    }
}
