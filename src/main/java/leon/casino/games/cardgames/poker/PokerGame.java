package leon.casino.games.cardgames.poker;


import leon.casino.games.utils.gamblegames.BetCreator;
import leon.casino.games.utils.gamblegames.GambleGame;
import leon.casino.profile.Profile;
import leon.casino.profile.ProfileManager;

import leon.casino.games.cardgames.CardDealer;
import leon.casino.profile.ProfileManagerMenu;
import leon.tools.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jarrydstamatelos on 5/9/17.
 */
public class PokerGame extends GambleGame<PokerPlayer> {
    private final CardDealer dealer = new CardDealer();

    public PokerGame(List<Profile> profileList) {
        super(profileList);
    }

    private void setup() {
        Console.println("Beginning a game of poker...");

        // create players
        int numberOfPlayers = Console.getIntegerInput("How many players will be playing?");
        ProfileManager profileManager = new ProfileManager(super.profileList);
        for (int i = 0; i < numberOfPlayers; i++) {
            Profile profile = profileManager.selectProfile();
            PokerPlayer pokerPlayer = new PokerPlayer(profile);
            playerList.add(pokerPlayer);
        }

        // dealing of cards
        dealer.deal(playerList, 5);

        // placing of bets
        for (PokerPlayer player : playerList) {
            player.setBetAmount(BetCreator.createBetAmount(player.getProfile()));
        }

    }


    public PokerPlayer getWinner() {
        PokerPlayer highestEvaluatedPlayer = null;
        for (PokerPlayer currentEvaluatedPlayer : playerList) {
            // TODO - Implement game-winning logic
            //if(currentEvaluatedPlayer.evaluate() > highestEvaluatedPlayer.evaluate()) {
            //highestEvaluatedPlayer = currentEvaluatedPlayer;
            //}
        }
        return highestEvaluatedPlayer;
    }


    /**
     * Set up the game
     * allow each player to
     */ // TODO - Implement game-ending logic
    public void run() {
        setup();

        String input;
        do {
            playRound();
            Console.println("A round just ended...");
            Console.println("I do not know the game-ending condition...");
            input = Console.getStringInput("[end game], [continue]");
        } while (!input.equalsIgnoreCase("end game"));
    }

    private void playRound() {
        Console.printDashes();

        Console.println("A new round has begun.");
        for (PokerPlayer player : playerList) {
            evaluateTurn(player);
        }

        Console.println("Determining the winner...");
        PokerPlayer winner = getWinner();

        Console.println("Congratulations, [ %s ], you got lucky.", winner.getProfile().getName());
        winner.increaseBalance(getPotValue());
    }

    /**
     * organically derives total pot value from environment
     *
     * @return sum of all bets on the table
     */
    public double getPotValue() {
        double potValue = -1; // temporary value
        for (PokerPlayer player : playerList) {
            double playerBetAmount = player.getBetAmount();
            if (playerBetAmount > potValue) {
                potValue += playerBetAmount;
            }
        }
        return potValue;
    }

    /**
     * organically derives highest bet amount from environment
     *
     * @return value of the highest bid amongst the playerList
     */
    public double getGreatestBet() {
        double highestBet = -1; // temporary value
        for (PokerPlayer player : playerList) {
            double playerBetAmount = player.getBetAmount();
            if (playerBetAmount > highestBet) {
                highestBet = playerBetAmount;
            }
        }
        return highestBet;
    }


    void evaluateTurn(PokerPlayer player) {
        Profile playerProfile = player.getProfile();
        String playerName = playerProfile.getName();
        double playerBalance = playerProfile.getBalance();
        int playerBet = player.getBetAmount().intValue();
        int playerHandTotal = player.getHandTotal();

        Console.printDashes();
        Console.println("Hey, [ %s ]!", playerName.toUpperCase());
        Console.println("Your current balance is [ %s ]", playerBalance);
        Console.println("Your current hand-total is [ %s ]", playerHandTotal);
        Console.println("You have currently bet an amount of [ %s ].", playerBet);
        Console.printDashes();

        Console.println("[ %s ], it is your turn!", playerName);
        Console.println("Your current options are as follows:");
        String choice = Console.getStringInput("[fold], [call], [raise]");
        switch (choice.toLowerCase()) { // TODO - Replace with PokerPlayerDecision enum
            case "fold":
                playerList.remove(player);
                break;

            case "call":
                player.setBetAmount(getGreatestBet() - player.getBetAmount());
                break;

            case "raise":
                double raise = Console.getDoubleInput("How much would you like to raise?");
                player.setBetAmount(getGreatestBet() + raise);
                break;

            default:
                Console.println("Invalid user input!");
                evaluateTurn(player);
                break;
        }
    }
}
