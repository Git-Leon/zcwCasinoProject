package com.github.curriculeon.casino.games.cardgames.poker;

import com.github.curriculeon.casino.games.cardgames.CardPlayer;
import com.github.curriculeon.casino.profile.ProfileInterface;

public class PokerPlayer extends CardPlayer {
    private Double betAmount;

    PokerPlayer(ProfileInterface profile) {
        super(profile);
    }

    Double getBetAmount() {
        return this.betAmount;
    }

    void setBetAmount(double newBetValue) {
        this.betAmount = newBetValue;
    }

    void collectEarnings(double earningValue) {
        super.profile.increaseBalance(earningValue);
    }
}
