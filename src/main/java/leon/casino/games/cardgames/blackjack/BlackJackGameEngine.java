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
 */
public class BlackJackGameEngine extends GameEngine<BlackJackPlayer, BlackJackGame> {
    public BlackJackGameEngine(List<Profile> profiles) {
        super(new BlackJackGame(), profiles);
        getGame().addPlayers(convertToPlayers(profiles));
    }

    @Override
    public final void evaluateTurn(BlackJackPlayer player) {
        do {
            BlackJackPlayerState playerState = BlackJackPlayerState.getState(player);

            BlackJackGameEngineDecision gameDecision = BlackJackGameEngineDecision.getDecision(playerState);
            gameDecision.perform(this.getGame(), player);
            Console.println(gameDecision.name() + "!");
        } while (player.getState().equals(BlackJackGameEngineDecision.UNDER));
    }

    @Override
    public final BlackJackPlayer convertToPlayer(Profile profile) {
        return new BlackJackPlayer(profile);
    }
}
