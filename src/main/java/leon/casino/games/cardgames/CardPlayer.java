package leon.casino.games.cardgames;

import leon.tools.Console;
import leon.casino.games.Player;
import leon.casino.profile.Profile;
import leon.casino.games.cardgames.cardutilities.Card;
import leon.casino.games.cardgames.cardutilities.Deck;

import java.util.ArrayList;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class CardPlayer extends Player {
    private final ArrayList<Card> hand = new ArrayList<>();

    public CardPlayer(Profile profile) {
        super(profile);
    }

    public void getCard(Deck deck) {
        Card card = deck.pop();
        this.hand.add(card);
    }

    public int getHandTotal() {
        int total = 0;
        for (Card card : this.hand) {
            total += card.getValue();
        }
        return total;
    }


    public void printHand() {
        Console.printDashes();
        if (!this.hand.isEmpty()) {
            Console.println("Displaying the hand of [ %s ]", profileName);
            for (Card card : this.hand) {
                Console.println(card.toString());
            }
        } else {
            Console.println("The contents of [ %s ]'s hand is empty", profileName);
        }
    }
}
