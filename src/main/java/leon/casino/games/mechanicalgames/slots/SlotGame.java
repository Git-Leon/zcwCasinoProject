package leon.casino.games.mechanicalgames.slots;

import leon.casino.games.utils.Game;
import leon.casino.games.utils.gamblegames.GambleGame;
import leon.casino.profile.Profile;

import java.util.List;

/**
 * Created by sarahweisser on 5/11/17.
 */

public class SlotGame extends GambleGame<SlotPlayer> {
    private ReelImage image1;
    private ReelImage image2;
    private ReelImage image3;

    public SlotGame(List<Profile> profileList) {
        super(profileList);
    }

    public void spinReel() {
        this.image1 = ReelImage.getRandom();
        this.image2 = ReelImage.getRandom();
        this.image3 = ReelImage.getRandom();
    }

    public ReelImage getImage1() {
        return image1;
    }

    public ReelImage getImage2() {
        return image2;
    }

    public ReelImage getImage3() {
        return image3;
    }

    public void setImage1(ReelImage image1) {
        this.image1 = image1;
    }

    public void setImage2(ReelImage image2) {
        this.image2 = image2;
    }

    public void setImage3(ReelImage image3) {
        this.image3 = image3;
    }

    @Override
    public void run() {

    }
}