package leon.casino.cardgames;

import leon.casino.Console;
import leon.casino.Player;
import leon.casino.Profile;
import leon.casino.cardgames.cardutilities.Card;
import leon.casino.cardgames.cardutilities.Deck;

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
        String cardName = card.toString();

        this.hand.add(card);
        Console.println("[ %s ] has been added to hand of [ %s ]", cardName, profileName);
        printHandTotal();
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

    public void printHandTotal() {
        Console.println("[ %s ]'s hand-total is [ %s ]", profileName, getHandTotal());
    }
}
