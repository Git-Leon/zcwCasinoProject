package leon.casino.profile;

import leon.casino.AsbtractDecisisonMenu;
import leon.tools.Console;

/**
 * Created by leon on 2/25/18.
 */
public class ProfileManagerMenu extends AsbtractDecisisonMenu<ProfileManagerSelection> {
    public ProfileManagerMenu() {
        super(ProfileManagerSelection.values());
    }

    @Override
    public ProfileManagerSelection getInput() {
        ProfileManagerSelection selection = null;
        do {
            String userInputString = Console.getStringInput("Select an option.").toUpperCase();
            try {
                selection = ProfileManagerSelection.valueOf(userInputString);
            } catch (IllegalArgumentException iae) {
                super.handleIllegalArgument(userInputString);
            }
        } while(selection != null);
        return selection;
    }
}
