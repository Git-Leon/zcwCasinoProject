package leon.casino.games.cardgames.blackjack;

import leon.casino.games.utils.Game;
import leon.casino.profile.Profile;
import leon.casino.profile.ProfileManager;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayer;
import leon.tools.Console;

import java.util.Arrays;
import java.util.List;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class BlackJackGame extends Game<BlackJackPlayer> {
    private BlackJackDealer dealer;

    public BlackJackGame() {
        Console.println("Beginning a game of blackjack...");
        this.players = Arrays.asList(createPlayers());
        this.dealer = new BlackJackDealer();

        dealer.deal(players, 2);
    }

    @Override
    public BlackJackPlayer[] getPlayers() {
        return players.stream().toArray(BlackJackPlayer[]::new);
    }


    @Override
    public void addPlayer(BlackJackPlayer player) {
        players.add(player);
    }

    @Override
    public void removePlayer(BlackJackPlayer player) {
        players.remove(player);
    }

    @Override
    public Boolean contains(BlackJackPlayer player) {
        return players.contains(player);
    }

    @Override
    public void run() {

    }

    public void printTable() {
        for (BlackJackPlayer player : players) {
            player.printHand();
        }
        dealer.printHand();
    }

    private BlackJackPlayer[] createPlayers() {
        int numberOfPlayers = Console.getIntegerInput("How many players will be playing?");
        Profile[] profiles = ProfileManager.DEPRECATED_INSTANCE.getProfiles(numberOfPlayers);
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
