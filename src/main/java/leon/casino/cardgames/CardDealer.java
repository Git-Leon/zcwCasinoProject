package leon.casino.cardgames;

/**
 * Created by leon on 5/11/17.
 */

import leon.tools.Console;
import leon.casino.Profile;
import leon.casino.cardgames.cardutilities.Deck;

import java.util.Arrays;
import java.util.List;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class CardDealer extends CardPlayer {
    private final Deck deck;

    public CardDealer() {
        this(new Deck());
    }

    // This constructor exists for testing purposes
    public CardDealer(Deck deck) {
        super(new Profile("DEALER", 0));
        this.deck = deck;
        this.deck.shuffle();
    }


    public final void deal(CardPlayer player, int numberOfCards) {
        Console.printDashes();
        Console.println("The dealer is dealing cards to [ %s ]", player.profile.getName());
        for (int i = 0; i < numberOfCards; i++) {
            player.getCard(this.deck);
        }
    }

    public final void deal(List<? extends CardPlayer> players, int numberOfCards) {
        for(CardPlayer player : players) {
            deal(player, numberOfCards);
        }
    }

    public final void deal(CardPlayer[] players, int numberOfCards) {
        deal(Arrays.asList(players), numberOfCards);
    }

}


