package leon.casino;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class ProfileManager {
    /**
     * @return array of respective profile objects
     */
    public static Profile createProfile() {
        Console.printDashes();
        Console.println("Creating new player profile...");

        String name = Console.getStringInput("Enter player's name");
        double startingBalance = Console.getDoubleInput("Enter balance");
        Profile newPlayer = new Profile(name, startingBalance);
        Casino.registerPlayer(newPlayer);

        return newPlayer;
    }

    /**
     * @param numberOfPlayers - number of profiles to create
     * @return array of respective profile objects
     */
    public static Profile[] createProfiles(int numberOfPlayers) {
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
    public static Profile[] getProfiles(int numberOfPlayers) {
        Profile[] profiles = new Profile[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            Console.printDashes();
            Console.println("Requesting action regarding player number %s...", i);
            String userDecision = Console.getStringInput("Would you like to [create] a new profile, or [select] a preexisting?");
            if ("create".equalsIgnoreCase(userDecision)) {
                profiles[i] = ProfileManager.createProfile();
            } else if("select".equalsIgnoreCase(userDecision)) {
                profiles[i] = ProfileManager.selectProfile();
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
    public static Profile selectProfile() {
        if (!Casino.profiles.isEmpty()) {
            printProfilesInformation();
            long playerId = Console.getLongInput("Please enter the desired player-profile's id number: ");
            for (Profile player : Casino.profiles) {
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
    public static void printProfilesInformation() {
        Console.println("Displaying a list of player-profiles registered at our Casino...");
        for (Profile profile : Casino.profiles) {
            profile.printInformation();
        }
    }
}
