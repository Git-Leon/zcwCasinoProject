package leon.casino;


import leon.casino.cardgames.war.War;
import leon.casino.cardgames.blackjack.BlackJackGame;
import leon.casino.cardgames.poker.PokerGame;
import leon.casino.mechanicalgames.slots.SlotGame;

import java.util.ArrayList;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public final class Casino {
    public static final ArrayList<Profile> profiles = new ArrayList<Profile>();

    public static final void start() {
        while (true) {
            Console.printDashes();
            Console.println("Welcome to MyCasino main menu!");
            Console.println("From here, you can [create profile], [select game], [exit]");
            String userInput = Console.getStringInput("What would you like to do?");

            Console.printDashes();
            // TODO - Replace with MainMenuOption enum
            switch (userInput.toLowerCase()) {
                case "create profile":
                    int numberOfProfiles = Console.getIntegerInput("How many player profiles would you like to create?");
                    ProfileManager.createProfiles(numberOfProfiles);
                    break;
                case "select profile":
                    ProfileManager.selectProfile();
                    break;
                case "select game":
                    selectGame();
                    break;
                case "exit":
                    Console.printDashes();
                    Console.println("Good bye!");
                    ProfileManager.printProfilesInformation();
                    return;
                default:
                    Console.println("[ %s ] is not a recognized command!", userInput);
                    Console.println("Going back to main menu...");
                    break;
            }
        }
    }

    public static void selectGame() {
        String gameSelection = Console.getStringInput("Would you like to play [Slots], [Roulette], [BlackJack], [Poker], or [War]?");

        // TODO - Replace with GameSelect enum
        switch (gameSelection.toLowerCase()) {
            case "war":
                new War().play();
                break;
            case "blackjack":
                new BlackJackGame().start();
                break;
            case "poker":
                new PokerGame().play();
                break;
            case "slots":
                new SlotGame().play();
                break;
        }
    }

    public static final void registerPlayer(Profile someDude) {
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
}