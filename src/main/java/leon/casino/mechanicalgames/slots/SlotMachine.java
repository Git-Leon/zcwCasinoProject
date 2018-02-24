package leon.casino.mechanicalgames.slots;

import leon.tools.Console;

/**
 * Created by sarahweisser on 5/11/17.
 */
public class SlotMachine {

    private SlotPlayer player;
    Reel.ReelImage image1;
    Reel.ReelImage image2;
    Reel.ReelImage image3;

    public SlotMachine(SlotPlayer sp) {
        this.player = sp;
    }

    private void displayImages() {
        Console.println("Results: || %s || %s || %s", image1, image2, image3);
    }

    public boolean matchImages() {
        return image1.equals(image2) && image2.equals(image3);
    }

    public double spinReel() {
        this.image1 = Reel.spin();
        this.image2 = Reel.spin();
        this.image3 = Reel.spin();
        displayImages();
        if (image1.name().equals(image2.name()) && image2.name().equals(image3.name())) {
            int reelImageValue = image1.getValue();
            int earningMultiplierValue = Math.abs(reelImageValue/1000);
            int earningValue = reelImageValue * earningMultiplierValue;
            Console.println("Congratulations, you have earned $[ %s ]!", earningValue);
            player.getProfile().increaseBalance(earningValue);
            return 0;
        } else {
            System.out.println("No Match.  Please try again.");
            return 0;
        }
    }


}
