package leon.casino;

import leon.casino.cardgames.cardutilities.Card;

import java.util.ArrayList;

/**
 * Created by leon on 5/11/17.
 */
public class Player {
    public final Profile profile;
    protected final String profileName;

    public Player(Profile profile) {
        this.profile = profile;
        this.profileName = profile.getName();
    }

    public Profile getProfile() {
        return profile;
    }
}
