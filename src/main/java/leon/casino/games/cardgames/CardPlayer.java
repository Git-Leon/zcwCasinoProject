package leon.casino.games.cardgames;

import leon.casino.games.cardgames.cardutilities.Hand;
import leon.tools.Console;
import leon.casino.games.Player;
import leon.casino.profile.Profile;
import leon.casino.games.cardgames.cardutilities.Card;
import leon.casino.games.cardgames.cardutilities.Deck;
import leon.tools.StringAssembler;

import java.util.ArrayList;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class CardPlayer extends Player {
    private final Hand hand = new Hand();

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

    @Override
    public String toString() {
        StringAssembler stringAssembler = new StringAssembler("\n");
        stringAssembler.append(super.toString());
        hand.forEach((card) -> stringAssembler.append(card.toString()));
        return stringAssembler.toString();
    }


    public void printHand() {
        Console.printDashes();
        if (!this.hand.isEmpty()) {
            Console.println("Displaying the hand of [ %s ]", profileName);
            hand.forEach((card) -> Console.println(card.toString()));
        } else {
            Console.println("The contents of [ %s ]'s hand is empty", profileName);
        }
    }
}
