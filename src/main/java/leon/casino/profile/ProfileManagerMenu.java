package leon.casino.profile;

import leon.casino.AbstractDecisisonMenu;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayerDecision;
import leon.tools.Console;

/**
 * Created by leon on 2/25/18.
 */
public class ProfileManagerMenu extends AbstractDecisisonMenu<ProfileManagerSelection> {
    public ProfileManagerMenu() {
        super(ProfileManagerSelection.values());
    }

    @Override
    public ProfileManagerSelection getInput() {
        return ProfileManagerSelection.valueOf(getInputFromUser().toUpperCase());
    }
}
