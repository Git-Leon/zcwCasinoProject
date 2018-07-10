package leon.casino.games.cardgames.poker;

import leon.casino.games.utils.GameEngine;
import leon.casino.profile.Profile;

/**
 * Created by leon on 3/8/18.
 */
public class PokerGameEngine extends GameEngine<PokerPlayer, PokerGame> {
    public PokerGameEngine() {
        super(new PokerGame());
    }

    @Override
    public void evaluateTurn(PokerPlayer pokerPlayer) {
        // TODO - Implement Logic
    }

    @Override
    protected PokerPlayer convertToPlayer(Profile profile) {
        return new PokerPlayer(profile);
    }
}
