package leon.casino.games.cardgames.blackjack;

import leon.casino.games.Player;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayer;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayerDecision;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayerDecisionMenu;
import leon.casino.games.utils.Game;
import leon.casino.games.utils.gamblegames.GambleGame;
import leon.casino.profile.Profile;
import leon.casino.profile.ProfileManager;
import leon.tools.Console;

import java.util.List;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class BlackJackGame extends GambleGame<BlackJackPlayer> {
    private BlackJackDealer dealer;

    public BlackJackGame(List<Profile> profileList) {
        super(profileList);
        this.dealer = new BlackJackDealer();
    }


    @Override
    public void run() {
        dealer.deal(playerList, 2);
        for(BlackJackPlayer player : playerList) {
            BlackJackPlayerDecisionMenu menu = new BlackJackPlayerDecisionMenu(this, player);
            BlackJackPlayerDecision playerDecision = menu.getInput();
            playerDecision.perform(this, player);
        }
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
