package leon.casino.cardgames.blackjack;

import leon.casino.cardgames.CardGame;
import leon.tools.Console;
import leon.casino.Profile;
import leon.casino.ProfileManager;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class BlackJackGame extends CardGame {
    private BlackJackPlayer[] currentPlayers;
    private BlackJackDealer dealer;

    public void start() {
        setup();
        play();
        dealer.hit();
        play();
    }

    public void play() {
        for (BlackJackPlayer player : currentPlayers) {
            play(player);
        }
    }

    private void play(BlackJackPlayer player) {
        String moveDecision;
        do {
            Profile playerProfile = player.getProfile();
            String playerState = player.getState();
            String playerName = playerProfile.getName();
            double playerBalance = playerProfile.getBalance();
            int playerBet = player.getBetAmount().intValue();
            int playerHandTotal = player.getHandTotal();
            int dealerHandTotal = dealer.getHandTotal();

            Console.printDashes();
            Console.println("Hey, [ %s ]!", playerName.toUpperCase());
            Console.println("Your current balance is [ %s ]", playerBalance);
            Console.println("Your current hand-total is [ %s ]", playerHandTotal);
            Console.println("You have currently bet an amount of [ %s ].", playerBet);
            Console.printDashes();

            // TODO - Replace with PlayerState enum
            switch (playerState) {
                case "blackjack":
                    Console.println("CardPlayer blackjack!");
                    playerProfile.increaseBalance(playerBet);
                    return;
                case "bust":
                    Console.println("CardPlayer Bust!");
                    playerProfile.decreaseBalance(playerBet);
                    return;
                case "done":
                    String baseMessage = "[ %s ] has a %s  hand then the dealer.";
                    if (playerHandTotal > dealerHandTotal) {
                        Console.println(baseMessage, playerName, "better");
                        playerProfile.increaseBalance(playerBet);
                    } else {
                        Console.println(baseMessage, playerName, "worse");
                        playerProfile.decreaseBalance(playerBet);
                    }
                    return;
                case "under":
                    Console.println("%s, your available moves are [hit], [stand], [split]",playerName);
                    Console.println("You can also view your [hand] and the [table].", playerName);
                    moveDecision = Console.getStringInput("What action would you like to take?");

                    // TODO - Replace with MoveDecision enum
                    switch (moveDecision.toLowerCase()) {
                        case "hit":
                            dealer.deal(player, 1);
                            break;
                        case "stand":
                            player.finish();
                            break;
                        case "split":
                            break;
                        case "hand":
                            player.printHand();
                            break;
                        case "table":
                            this.printTable();
                            break;
                        default:
                            Console.println("Invalid command!");
                            continue;
                    }
                    break;
                default:
                    moveDecision = "";
            }
        } while (!"stand".equalsIgnoreCase(moveDecision));
    }

    private void printTable() {
        for (BlackJackPlayer player : currentPlayers) {
            player.printHand();
        }
        dealer.printHand();
    }

    private void setup() {
        Console.println("Beginning a game of blackjack...");
        this.currentPlayers = createPlayers();
        this.dealer = new BlackJackDealer();

        dealer.deal(currentPlayers, 2);
    }

    private BlackJackPlayer[] createPlayers() {
        int numberOfPlayers = Console.getIntegerInput("How many players will be playing?");
        Profile[] profiles = ProfileManager.getProfiles(numberOfPlayers);
        BlackJackPlayer[] blackJackPlayers = new BlackJackPlayer[numberOfPlayers];

        // create profiles
        for (int i = 0; i < blackJackPlayers.length; i++) {
            Profile profile = profiles[i];
            double betAmount = profile.createBetAmount();
            BlackJackPlayer player = new BlackJackPlayer(profile, betAmount);
            blackJackPlayers[i] = player;
        }
        return blackJackPlayers;
    }


}
