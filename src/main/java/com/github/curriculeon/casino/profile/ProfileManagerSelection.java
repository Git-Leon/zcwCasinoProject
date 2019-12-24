package com.github.curriculeon.casino.profile;

import com.github.curriculeon.casino.CasinoInterface;
import com.github.curriculeon.casino.Decision;
import com.github.curriculeon.tools.Console;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by leon on 2/25/18.
 */
public enum ProfileManagerSelection implements Decision {
    SELECT((casino) -> {
        int numberOfProfiles = Console.getIntegerInput("How many player profiles would you like to create?");
        casino.getProfileManager().createProfiles(numberOfProfiles);
    }),

    CREATE((casino) -> {
        casino.getProfileManager().createProfile();
    });

    private final Consumer<CasinoInterface> profileConsumer;

    ProfileManagerSelection(Consumer<CasinoInterface> casinoConsumer) {
        this.profileConsumer = casinoConsumer;
    }

    public void perform(CasinoInterface casino) {
        profileConsumer.accept(casino);
    }

    @Override
    public void perform() {
    }
}
