package leon.casino.games.cardgames.blackjack;

import leon.casino.games.cardgames.blackjack.player.BlackJackPlayer;
import leon.casino.games.cardgames.blackjack.player.BlackJackPlayerState;
import leon.casino.games.utils.Game;
import leon.casino.games.utils.GameEngine;
import leon.casino.profile.Profile;
import leon.tools.Console;

import java.util.List;

/**
 * Created by leon on 2/25/18.
 * Responsible for mediating user-input and BlackJackGame
 */
public class BlackJackGameEngine extends GameEngine<BlackJackPlayer, BlackJackGame> {
    public BlackJackGameEngine(List<Profile> profiles) {
        super(new BlackJackGame(profiles), profiles);
        getGame().addPlayers(convertToPlayers(profiles));
    }

    @Override
    public final void evaluateTurn(BlackJackPlayer player) {
        do {
            // get current player state
            BlackJackPlayerState playerState = BlackJackPlayerState.getState(player);

            // inform user of current state; prompt user for decision;
            BlackJackGameEngineDecision gameDecision = BlackJackGameEngineDecision.getDecision(playerState);

            // perform user decision
            gameDecision.perform(getGame(), player);

            // display game decision-name; i.e. - UNDER, BLACKJACK, BUST, STAND
            Console.println(gameDecision.name() + "!");
        } while (player.getState().equals(BlackJackGameEngineDecision.UNDER));
    }

    @Override
    public final BlackJackPlayer convertToPlayer(Profile profile) {
        return new BlackJackPlayer(profile);
    }
}
