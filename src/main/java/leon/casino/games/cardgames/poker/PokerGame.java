package leon.casino.games.cardgames.poker;


import leon.casino.BetCreator;
import leon.casino.Profile;
import leon.casino.ProfileManager;
import leon.casino.games.GameInterface;

import leon.casino.games.cardgames.CardDealer;
import leon.tools.Console;

import java.util.ArrayList;

/**
 * Created by jarrydstamatelos on 5/9/17.
 */
public class PokerGame implements GameInterface {
    private final ArrayList<PokerPlayer> players = new ArrayList<>();
    private final CardDealer dealer = new CardDealer();

    private void setup() {
        Console.println("Beginning a game of poker...");
        int numberOfPlayers = Console.getIntegerInput("How many players will be playing?");
        Profile[] profiles = ProfileManager.getProfiles(numberOfPlayers);

        // creation of players
        for (Profile profile : profiles) {
            PokerPlayer player = new PokerPlayer(profile);
            players.add(player);
        }

        // dealing of cards
        dealer.deal(players, 5);

        // placing of bets
        for(PokerPlayer player : players) {
            player.setBetAmount(BetCreator.createBetAmount(player.getProfile()));
        }

    }


    public PokerPlayer getWinner() {
        PokerPlayer highestEvaluatedPlayer = null;
        for (PokerPlayer currentEvaluatedPlayer : players) {
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
    public void play() {
        setup();

        String input;
        do {
            playRound();
            Console.println("A round just ended...");
            Console.println("I do not know the game-ending condition...");
            input = Console.getStringInput("[end game], [continue]");
        } while(!input.equalsIgnoreCase("end game"));
    }

    private void playRound() {
        Console.printDashes();

        Console.println("A new round has begun.");
        for (PokerPlayer player : players) {
            play(player);
        }

        Console.println("Determining the winner...");
        PokerPlayer winner = getWinner();

        Console.println("Congratulations, [ %s ], you got lucky.", winner.getProfile().getName());
        winner.collectEarnings(getPotValue());
    }

    /**
     * organically derives total pot value from environment
     *
     * @return sum of all bets on the table
     */
    public double getPotValue() {
        double potValue = -1; // temporary value
        for (PokerPlayer player : players) {
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
     * @return value of the highest bid amongst the players
     */
    public double getGreatestBet() {
        double highestBet = -1; // temporary value
        for (PokerPlayer player : players) {
            double playerBetAmount = player.getBetAmount();
            if (playerBetAmount > highestBet) {
                highestBet = playerBetAmount;
            }
        }
        return highestBet;
    }


    void play(PokerPlayer player) {
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
                players.remove(player);
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
                play(player);
                break;
        }
    }

}
