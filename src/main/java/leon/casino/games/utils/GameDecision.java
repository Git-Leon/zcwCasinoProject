package leon.casino.games.utils;

import leon.casino.games.Player;

/**
 * Created by leon on 2/25/18.
 * this class is used in conjunction with Enums to ensure Game has finite interactions with player
 */
public interface GameDecision<
        GameType extends GameInterface,
        PlayerType extends Player> {
    void perform(GameType game, PlayerType player);
}