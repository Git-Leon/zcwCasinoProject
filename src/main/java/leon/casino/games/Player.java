package leon.casino.games;

import leon.casino.profile.Profile;
import leon.tools.StringAssembler;

/**
 * Created by leon on 5/11/17.
 */
public class Player implements PlayerInterface {
    protected final Profile profile;
    protected final String profileName;

    public Player(Profile profile) {
        this.profile = profile;
        this.profileName = profile.getName();
    }

    public Profile getProfile() {
        return profile;
    }

    public String getName() {
        return profileName;
    }

    @Override
    public String toString() {
        return new StringAssembler("\n")
                .append(super.toString())
                .append("Profile Id: %s", profile.getProfileId())
                .append("Name: %s", profileName)
                .toString();
    }
}
