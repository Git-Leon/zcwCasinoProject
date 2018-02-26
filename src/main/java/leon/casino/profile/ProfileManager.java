package leon.casino.profile;

import leon.tools.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class ProfileManager {
    public static volatile ProfileManager DEPRECATED_INSTANCE = new ProfileManager();
    public List<Profile> profiles = new ArrayList<Profile>();
    /**
     * @return array of respective profile objects
     */
    public Profile createProfile() {
        Console.printDashes();
        Console.println("Creating new player profile...");

        String name = Console.getStringInput("Enter player's name");
        double startingBalance = Console.getDoubleInput("Enter balance");
        Profile newPlayer = new Profile(name, startingBalance, (long)profiles.size());
        registerPlayer(newPlayer);

        return newPlayer;
    }

    /**
     * @param numberOfPlayers - number of profiles to create
     * @return array of respective profile objects
     */
    public Profile[] createProfiles(int numberOfPlayers) {
        Profile[] players = new Profile[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            Profile someNewGuy = createProfile();
            players[i] = someNewGuy;
        }
        return players;
    }

    /**
     * Request each user to make action regarding their profile
     * @param numberOfPlayers - number of players anticipated to generate profiles
     * @return array of respective profile objects
     */
    public Profile[] getProfiles(int numberOfPlayers) {
        Profile[] profiles = new Profile[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            Console.printDashes();
            Console.println("Requesting action regarding player number %s...", i);
            String userDecision = Console.getStringInput("Would you like to [create] a new profile, or [select] a preexisting?");
            if ("create".equalsIgnoreCase(userDecision)) {
                profiles[i] = createProfile();
            } else if("select".equalsIgnoreCase(userDecision)) {
                profiles[i] = selectProfile();
            } else {
                Console.println("[ %s ] is not recognized as a valid command.", userDecision);
                profiles[i] = getProfiles(1)[0];
            }
        }
        return profiles;
    }

    /**
     * Select profile from memory, create profile if none exists
     * @return selected profile
     */
    public Profile selectProfile() {
        if (!profiles.isEmpty()) {
            printProfilesInformation();
            long playerId = Console.getLongInput("Please enter the desired player-profile's id number: ");
            for (Profile player : profiles) {
                if (player.getProfileId() == playerId) {
                    return player;
                }
            }
            Console.println("[ %s ] is not a profile-id that our records recognize.", playerId);
        } else {
            Console.println("There are currently no profiles in our records.");
            Console.println("Try creating some player-profiles first.");
        }
        return createProfile();
    }

    /**
     * Print information from each profile in memory
     */
    public void printProfilesInformation() {
        Console.println("Displaying a list of player-profiles registered at our Casino...");
        for (Profile profile : profiles) {
            profile.printInformation();
        }
    }


    public void registerPlayer(Profile someDude) {
        Console.printDashes();
        String name = someDude.getName();
        Console.println("Checking my database to see if I know you like that...");
        if (profiles.contains(someDude)) {
            Console.println("Oh, %s! I didn't realize it was you! Welcome back!", name);
            someDude.printInformation();
        } else {
            Console.println("The Casino has registered a new profile!");
            Console.println("Homie's profile-name is " + name);
            profiles.add(someDude);
        }
    }

    public boolean contains(Profile someDude) {
        return profiles.contains(someDude);
    }
}
