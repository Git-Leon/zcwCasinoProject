package com.github.curriculeon.casino.games.mechanicalgames.slots;

import com.github.curriculeon.tools.RandomUtils;

/**
 * Created by leon on 2/25/18.
 */
public enum ReelImage {
    CHERRY(500),
    ORANGE(500),
    WATERMELON(500),
    LEMON(500),
    BAR(500),
    DOUBLEBAR(1000),
    TRIPLEBAR(2000),
    LUCKYSEVEN(5000);
    private static final ReelImage[] images = {
            ReelImage.CHERRY,
            ReelImage.CHERRY,
            ReelImage.CHERRY,
            ReelImage.ORANGE,
            ReelImage.ORANGE,
            ReelImage.WATERMELON,
            ReelImage.WATERMELON,
            ReelImage.WATERMELON,
            ReelImage.WATERMELON,
            ReelImage.LEMON,
            ReelImage.LEMON,
            ReelImage.LEMON,
            ReelImage.LEMON,
            ReelImage.BAR,
            ReelImage.BAR,
            ReelImage.BAR,
            ReelImage.BAR,
            ReelImage.DOUBLEBAR,
            ReelImage.DOUBLEBAR,
            ReelImage.DOUBLEBAR,
            ReelImage.TRIPLEBAR,
            ReelImage.TRIPLEBAR,
            ReelImage.LUCKYSEVEN
    };

    private int value;

    ReelImage(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static ReelImage getRandom() {
        return RandomUtils.selectElement(images);
    }
}
