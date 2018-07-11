package leon.casino.games.cardgames.blackjack;

import leon.casino.games.cardgames.blackjack.player.BlackJackPlayer;
import leon.casino.games.utils.Game;
import leon.casino.profile.Profile;
import leon.casino.profile.ProfileManager;
import leon.tools.Console;

import java.util.List;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class BlackJackGame extends Game<BlackJackPlayer> {
    private BlackJackDealer dealer;

    public BlackJackGame() {
        this.dealer = new BlackJackDealer();
        dealer.deal(playerList, 2);
    }

    @Override
    public void run() {

    }

    public void printTable() {
        for (BlackJackPlayer player : playerList) {
            player.printHand();
        }
        dealer.printHand();
    }


    public BlackJackDealer getDealer() {
        return dealer;
    }
}
