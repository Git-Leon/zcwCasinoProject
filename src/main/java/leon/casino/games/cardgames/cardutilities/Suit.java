package leon.casino.games.cardgames.cardutilities;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public enum Suit {
    HEARTS("♥"),
    DIAMONDS("♦"),
    CLUBS("♣"),
    SPADES("♠");

    private String cardGraphic;

    Suit(String cardGraphic) {
        this.cardGraphic = cardGraphic;
    }

    public String getCardGraphic() {
        return cardGraphic;
    }

    public static int length() {
        return values().length;
    }
}
