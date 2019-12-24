package com.github.curriculeon.casino;

import com.github.curriculeon.casino.games.utils.GameSelection;
import com.github.curriculeon.casino.games.utils.GameSelectionMenu;
import com.github.curriculeon.casino.profile.ProfileManagerInterface;
import com.github.curriculeon.casino.profile.ProfileManagerMenu;
import com.github.curriculeon.casino.profile.ProfileManagerSelection;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by leon on 2/26/18.
 */
public enum CasinoDecision implements DecisionInterface {
    MANAGE_PROFILE((casino) -> {
        ProfileManagerMenu profileManagerMenu = new ProfileManagerMenu();
        ProfileManagerSelection profileManagerSelection = profileManagerMenu.getInput();
        profileManagerSelection.perform(casino);
    }),
    
    SELECT_GAME((casino) -> {
        GameSelectionMenu gameSelectionMenu = new GameSelectionMenu();
        GameSelection gameSelection = gameSelectionMenu.getInput();
        gameSelection.perform();
    }),
    
    EXIT((casino) -> {
        casino.getProfileManager().printProfilesInformation();
    });


    private final Consumer<CasinoInterface> casinoConsumer;

    CasinoDecision(Consumer<CasinoInterface> casinoConsumer) {
        this.casinoConsumer = casinoConsumer;
    }

    public void perform(CasinoInterface casino) {
        casinoConsumer.accept(casino);
    }
}