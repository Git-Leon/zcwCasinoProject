package leon.casino.games.utils;


import leon.casino.Decision;
import leon.casino.games.cardgames.blackjack.BlackJackGameEngine;
import leon.casino.games.cardgames.poker.PokerGameEngine;
import leon.casino.games.mechanicalgames.slots.SlotGameEngine;
import leon.casino.profile.Profile;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by leon on 2/25/18.
 */
public enum GameSelection implements Decision {
    BLACKJACK((profileList) -> new BlackJackGameEngine(profileList)),
    POKER((profileList) -> new PokerGameEngine(profileList)),
    SLOTS((profileList) -> new SlotGameEngine(profileList));


    private final Function<List<Profile>, GameEngineInterface> gameConstructor;

    GameSelection(Function<List<Profile>, GameEngineInterface> gameConstructor) {
        this.gameConstructor = gameConstructor;
    }

    public GameEngineInterface create(List<Profile> profileList) {
        return gameConstructor.apply(profileList);
    }
}
