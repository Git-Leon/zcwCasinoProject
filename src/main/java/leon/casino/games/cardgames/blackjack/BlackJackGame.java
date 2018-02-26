package leon.casino.games.cardgames.blackjack;

import leon.casino.Profile;
import leon.casino.ProfileManager;
import leon.casino.games.GameInterface;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayer;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayerState;
import leon.tools.Console;

import java.util.Arrays;
import java.util.List;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class BlackJackGame implements GameInterface {
    private List<BlackJackPlayer> currentPlayers;
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
            // black jack card player
            BlackJackPlayerState playerState = BlackJackPlayerState.getState(player);

            BlackJackGameDecision gameDecision = BlackJackGameDecision.getDecision(playerState);
            gameDecision.perform(this, player);
            Console.println(gameDecision.name() + "!");
        } while (player.getState().equals(BlackJackGameDecision.UNDER));
    }

    public void printTable() {
        for (BlackJackPlayer player : currentPlayers) {
            player.printHand();
        }
        dealer.printHand();
    }

    private void setup() {
        Console.println("Beginning a game of blackjack...");
        this.currentPlayers = Arrays.asList(createPlayers());
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
