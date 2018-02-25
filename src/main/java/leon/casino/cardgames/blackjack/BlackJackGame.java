package leon.casino.cardgames.blackjack;

import leon.casino.Profile;
import leon.casino.ProfileManager;
import leon.casino.cardgames.CardGame;
import leon.casino.cardgames.blackjack.player.BlackJackPlayer;
import leon.casino.cardgames.blackjack.player.BlackJackPlayerDecisionMenu;
import leon.casino.cardgames.blackjack.player.BlackJackPlayerState;
import leon.tools.Console;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class BlackJackGame implements CardGame {
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
            // profile
            Profile playerProfile = player.getProfile();
            String playerName = playerProfile.getName();

            // gambling
            double playerBalance = playerProfile.getBalance();
            int playerBet = player.getBetAmount().intValue();

            // card player
            int playerHandTotal = player.getHandTotal();
            int dealerHandTotal = dealer.getHandTotal();

            // black jack card player
            BlackJackPlayerState playerState = BlackJackPlayerState.getState(player);

            Console.printDashes();
            Console.println("Hey, [ %s ]!", playerName.toUpperCase());
            Console.println("Your current balance is [ %s ]", playerBalance);
            Console.println("Your current hand-total is [ %s ]", playerHandTotal);
            Console.println("You have currently bet an amount of [ %s ].", playerBet);
            Console.println("Your current play-state is [ %s ].", playerState.name());
            BlackJackGameDecision bjgd = BlackJackGameDecision.getDecision(playerState);
            bjgd.perform(this, player);
            Console.println(bjgd.name() + "!");
        } while (!player.getState().equals(BlackJackGameDecision.STAND));
    }

    public void printTable() {
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


    public BlackJackDealer getDealer() {
        return dealer;
    }
}
