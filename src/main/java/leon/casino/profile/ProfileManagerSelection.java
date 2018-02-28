package leon.casino.profile;

import leon.casino.Casino;
import leon.casino.Decision;
import leon.tools.Console;

import java.util.function.BiConsumer;

/**
 * Created by leon on 2/25/18.
 */
public enum ProfileManagerSelection implements Decision {
    SELECT((casino, profileManager) -> {
        int numberOfProfiles = Console.getIntegerInput("How many player profiles would you like to create?");
        profileManager.createProfiles(numberOfProfiles);
    }),

    CREATE((casino, profileManage) -> {
        profileManage.createProfile();
    });

    private final BiConsumer<Casino, ProfileManager> profileConsumer;

    ProfileManagerSelection(BiConsumer<Casino, ProfileManager> profileConsumer) {
        this.profileConsumer = profileConsumer;
    }

    @Override
    public void perform() {

    }
}
