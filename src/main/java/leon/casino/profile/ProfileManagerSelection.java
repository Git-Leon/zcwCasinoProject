package leon.casino.profile;

import leon.casino.Casino;
import leon.casino.Decision;
import leon.tools.Console;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by leon on 2/25/18.
 */
public enum ProfileManagerSelection implements Decision {
    SELECT((profileManager) -> {
        String prompt = "How many player profileList would you like to create?";
        int numberOfProfiles = Console.getIntegerInput(prompt);
        profileManager.createProfiles(numberOfProfiles);
    }),

    CREATE((profileManage) -> {
        profileManage.createProfile();
    });

    private final Consumer<ProfileManager> profileConsumer;

    ProfileManagerSelection(Consumer<ProfileManager> profileConsumer) {
        this.profileConsumer = profileConsumer;
    }

    public void perform(ProfileManager profileManager) {
        profileConsumer.accept(profileManager);
    }
}
