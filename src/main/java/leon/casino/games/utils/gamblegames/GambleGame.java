package leon.casino.games.utils.gamblegames;

import leon.casino.games.utils.Game;
import leon.casino.profile.Profile;

import java.util.List;

/**
 * @param <GamblerType> type of player to be playing
 *                      Ensures
 * @author leon on 07/12/2018
 */
abstract public class GambleGame<GamblerType extends GamblerInterface> extends Game<GamblerType> {
    protected final List<Profile> profileList;

    public GambleGame(List<Profile> profileList) {
        this.profileList = profileList;
    }

    public final List<Profile> getProfileList() {
        return this.profileList;
    }
}
