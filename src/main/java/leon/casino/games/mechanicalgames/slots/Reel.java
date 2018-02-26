package leon.casino.games.mechanicalgames.slots;

import leon.tools.RandomUtils;

/**
 * Created by sarahweisser on 5/11/17.
 */

public class Reel {
    //TODO - Implement logic
    public static ReelImage spin() {
        return null;
    }

    enum ReelImage {
        CHERRY(500),
        ORANGE(500),
        WATERMELON(500),
        LEMON(500),
        BAR(500),
        DOUBLEBAR(1000),
        TRIPLEBAR(2000),
        LUCKYSEVEN(5000);

        private int value;

        ReelImage(int value) {
            this.value = value;
        }

        int getValue() {
            return this.value;
        }

        static ReelImage getRandom() {
            //TODO - replace values() with ReelImage[] object
            return RandomUtils.selectElement(values());
        }

        @Override
        public String toString() {
            return name();
        }
    }

    private ReelImage[] images = {
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


    @Deprecated // TOOD - replace respective method calls with RealImage.getRandom()
    public ReelImage spinReel() {
        return ReelImage.getRandom();
    }

}
